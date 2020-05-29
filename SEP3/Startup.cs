using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using System.Net.Http;
using Microsoft.AspNetCore.Http;
using SEP3.Services;
using Syncfusion.Blazor;
using SEP3.Data;
using Blazored.SessionStorage;
using Microsoft.AspNetCore.Components.Authorization;
using Radzen;

using System;

namespace SEP3
{
    public class Startup
    {
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }

        // This method gets called by the runtime. Use this method to add services to the container.
        // For more information on how to configure your application, visit https://go.microsoft.com/fwlink/?LinkID=398940
        public void ConfigureServices(IServiceCollection services)
        {
         
            services.AddRazorPages();
            services.AddServerSideBlazor();
            services.AddSingleton<WeatherForecastService>();
            services.AddSingleton<BookService>();
            services.AddSingleton<IUserService,UserService>();
            services.AddSingleton(new HttpClient { BaseAddress = new Uri("https://localhost:8443") });
            services.AddSyncfusionBlazor();
            services.AddServerSideBlazor().AddHubOptions(o => { o.MaximumReceiveMessageSize = 102400000; });
            services.AddBlazoredSessionStorage();
            services.AddSingleton<NotificationService>();
            services.AddScoped<AuthenticationStateProvider, CustomAuthenticationStateProvider>();

            
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            Syncfusion.Licensing.SyncfusionLicenseProvider.RegisterLicense("MjYyNzExQDMxMzgyZTMxMmUzMFdwdGxFUERsVlJHOXI0U3BqcGN6SFV2bkgyMHpLZTNnMU9qYkpwUVBOQUE9");
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }
            else
            {
                app.UseExceptionHandler("/Error");
                // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
                app.UseHsts();
            }
            
            app.UseHttpsRedirection();
            app.UseStaticFiles();

            app.UseRouting();

            app.UseAuthentication();
            app.UseAuthorization();
            

            app.UseEndpoints(endpoints =>
            {
                endpoints.MapBlazorHub();
                endpoints.MapFallbackToPage("/_Host");
            });
        }
    }
}
