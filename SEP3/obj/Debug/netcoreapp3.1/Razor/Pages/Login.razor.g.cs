#pragma checksum "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\Pages\Login.razor" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "8558ab60fb714c01e61ecc54ff73c17cd94afe47"
// <auto-generated/>
#pragma warning disable 1591
namespace SEP3.Pages
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Components;
#nullable restore
#line 1 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\_Imports.razor"
using System.Net.Http;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\_Imports.razor"
using Microsoft.AspNetCore.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\_Imports.razor"
using Microsoft.AspNetCore.Components.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 4 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\_Imports.razor"
using Microsoft.AspNetCore.Components.Forms;

#line default
#line hidden
#nullable disable
#nullable restore
#line 5 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\_Imports.razor"
using Microsoft.AspNetCore.Components.Routing;

#line default
#line hidden
#nullable disable
#nullable restore
#line 6 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\_Imports.razor"
using Microsoft.AspNetCore.Components.Web;

#line default
#line hidden
#nullable disable
#nullable restore
#line 7 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\_Imports.razor"
using Microsoft.JSInterop;

#line default
#line hidden
#nullable disable
#nullable restore
#line 8 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\_Imports.razor"
using SEP3;

#line default
#line hidden
#nullable disable
#nullable restore
#line 9 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\_Imports.razor"
using SEP3.Shared;

#line default
#line hidden
#nullable disable
#nullable restore
#line 10 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\_Imports.razor"
using BlazorInputFile;

#line default
#line hidden
#nullable disable
#nullable restore
#line 11 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\_Imports.razor"
using Radzen;

#line default
#line hidden
#nullable disable
#nullable restore
#line 12 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\_Imports.razor"
using Radzen.Blazor;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\Pages\Login.razor"
using SEP3.Data;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\Pages\Login.razor"
using SEP3.Services;

#line default
#line hidden
#nullable disable
    [Microsoft.AspNetCore.Components.RouteAttribute("/")]
    public partial class Login : Microsoft.AspNetCore.Components.ComponentBase
    {
        #pragma warning disable 1998
        protected override void BuildRenderTree(Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder)
        {
            __builder.AddMarkupContent(0, @"<style>
    #login {
        border-radius: 5px;
        border: 4px solid #4267B2;
        margin: 20px;
        padding: 10px;
        align-content: center;
        text-align: center;
        left: 33%;
    }

    #header {
        color: #4267B2;
        font-size: 30px;
        margin: 20px;
    }
</style>

");
            __builder.OpenComponent<Microsoft.AspNetCore.Components.Forms.EditForm>(1);
            __builder.AddAttribute(2, "Model", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.Object>(
#nullable restore
#line 27 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\Pages\Login.razor"
                  user

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(3, "OnValidSubmit", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<Microsoft.AspNetCore.Components.EventCallback<Microsoft.AspNetCore.Components.Forms.EditContext>>(Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.Forms.EditContext>(this, 
#nullable restore
#line 27 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\Pages\Login.razor"
                                        UserLogin

#line default
#line hidden
#nullable disable
            )));
            __builder.AddAttribute(4, "ChildContent", (Microsoft.AspNetCore.Components.RenderFragment<Microsoft.AspNetCore.Components.Forms.EditContext>)((context) => (__builder2) => {
                __builder2.AddMarkupContent(5, "\r\n    ");
                __builder2.OpenComponent<Microsoft.AspNetCore.Components.Forms.DataAnnotationsValidator>(6);
                __builder2.CloseComponent();
                __builder2.AddMarkupContent(7, "\r\n\r\n    ");
                __builder2.AddMarkupContent(8, "<div id=\"header\">\r\n        <label>Login or Create an Account</label>\r\n    </div>\r\n    <br>\r\n    <br>\r\n    ");
                __builder2.OpenElement(9, "div");
                __builder2.AddAttribute(10, "id", "login");
                __builder2.AddAttribute(11, "class", "col-3");
                __builder2.AddMarkupContent(12, "\r\n        <br>\r\n        ");
                __builder2.OpenElement(13, "div");
                __builder2.AddAttribute(14, "class", "col-12");
                __builder2.AddMarkupContent(15, "\r\n            ");
                __builder2.AddMarkupContent(16, "<label class=\"col-12 font-weight-bold\">Your Username</label>\r\n            ");
                __builder2.OpenComponent<Microsoft.AspNetCore.Components.Forms.InputText>(17);
                __builder2.AddAttribute(18, "class", " form-control col-12 font-italic");
                __builder2.AddAttribute(19, "placeholder", "username");
                __builder2.AddAttribute(20, "Value", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.String>(
#nullable restore
#line 39 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\Pages\Login.razor"
                                                                             user.username

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(21, "ValueChanged", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<Microsoft.AspNetCore.Components.EventCallback<System.String>>(Microsoft.AspNetCore.Components.EventCallback.Factory.Create<System.String>(this, Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.CreateInferredEventCallback(this, __value => user.username = __value, user.username))));
                __builder2.AddAttribute(22, "ValueExpression", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.Linq.Expressions.Expression<System.Func<System.String>>>(() => user.username));
                __builder2.CloseComponent();
                __builder2.AddMarkupContent(23, "\r\n\r\n            &nbsp;");
                __Blazor.SEP3.Pages.Login.TypeInference.CreateValidationMessage_0(__builder2, 24, 25, 
#nullable restore
#line 41 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\Pages\Login.razor"
                                            () => user.username

#line default
#line hidden
#nullable disable
                );
                __builder2.AddMarkupContent(26, "\r\n        ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(27, "\r\n        <br>\r\n        <br>\r\n        ");
                __builder2.OpenElement(28, "div");
                __builder2.AddAttribute(29, "class", "col-12");
                __builder2.AddMarkupContent(30, "\r\n            ");
                __builder2.AddMarkupContent(31, "<label class=\"col-12 font-weight-bold\">Your Password</label>\r\n            ");
                __builder2.OpenElement(32, "input");
                __builder2.AddAttribute(33, "type", "password");
                __builder2.AddAttribute(34, "class", "form-control col-12 font-italic");
                __builder2.AddAttribute(35, "placeholder", "password");
                __builder2.AddAttribute(36, "value", Microsoft.AspNetCore.Components.BindConverter.FormatValue(
#nullable restore
#line 47 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\Pages\Login.razor"
                                                                                  user.password

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(37, "onchange", Microsoft.AspNetCore.Components.EventCallback.Factory.CreateBinder(this, __value => user.password = __value, user.password));
                __builder2.SetUpdatesAttributeName("value");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(38, "\r\n\r\n            &nbsp;");
                __Blazor.SEP3.Pages.Login.TypeInference.CreateValidationMessage_1(__builder2, 39, 40, 
#nullable restore
#line 49 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\Pages\Login.razor"
                                            () => user.password

#line default
#line hidden
#nullable disable
                );
                __builder2.AddMarkupContent(41, "\r\n        ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(42, "\r\n        <br>\r\n        <br>\r\n        ");
                __builder2.AddMarkupContent(43, @"<div class=""col-12 row"">
            <input type=""submit"" class=""form-control col-6 btn btn-primary"" style=""margin-right: 10px"" value=""Login"">
            <span>&nbsp;</span>
            <a href=""/createaccount"">Create Account</a>
            
            
        </div>
    ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(44, "\r\n");
            }
            ));
            __builder.CloseComponent();
        }
        #pragma warning restore 1998
#nullable restore
#line 64 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\Pages\Login.razor"
       

    public User user;
    public bool isCorrect;

    protected override async Task OnInitializedAsync()
    {
        user = new User();

    }
    public async void UserLogin()
    {
        //sending user to confirm
        User returnedUser = await userService.LoginAsync(user);

        // Authentification user and adding to session storage
        if (returnedUser.username.Equals(user.username))
        {
            ((CustomAuthenticationStateProvider)AuthenticationStateProvider).MarkUserAsAuthenticated(returnedUser);
            await sessionStorage.SetItemAsync("username", returnedUser.username);
            await sessionStorage.SetItemAsync("user", returnedUser);
            Console.WriteLine($"answer: {returnedUser}");

            navManager.NavigateTo("/main");
        }
        else
        {
            Dictionary<DateTime, string> events = new Dictionary<DateTime, string>();
            Console.WriteLine("Answer: " + returnedUser);
            NotificationMessage message = new NotificationMessage() { Severity = NotificationSeverity.Error, Summary = "Error Summary", Detail = "Error Detail", Duration = 4000 };
            notificationService.Notify(message);
            events.Add(DateTime.Now, $"{message.Severity} notification");
            await InvokeAsync(() => { StateHasChanged(); });
            // TODO Notification wrong user
        }

    }

    private async Task<bool> createAccountPage()
    {
        Console.WriteLine("*************** USER ACCOUNT CREATE******************");
        return await Task.FromResult(true);
    }





#line default
#line hidden
#nullable disable
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private Blazored.SessionStorage.ISessionStorageService sessionStorage { get; set; }
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private AuthenticationStateProvider AuthenticationStateProvider { get; set; }
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private NotificationService notificationService { get; set; }
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private NavigationManager navManager { get; set; }
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private IUserService userService { get; set; }
    }
}
namespace __Blazor.SEP3.Pages.Login
{
    #line hidden
    internal static class TypeInference
    {
        public static void CreateValidationMessage_0<TValue>(global::Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder, int seq, int __seq0, global::System.Linq.Expressions.Expression<global::System.Func<TValue>> __arg0)
        {
        __builder.OpenComponent<global::Microsoft.AspNetCore.Components.Forms.ValidationMessage<TValue>>(seq);
        __builder.AddAttribute(__seq0, "For", __arg0);
        __builder.CloseComponent();
        }
        public static void CreateValidationMessage_1<TValue>(global::Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder, int seq, int __seq0, global::System.Linq.Expressions.Expression<global::System.Func<TValue>> __arg0)
        {
        __builder.OpenComponent<global::Microsoft.AspNetCore.Components.Forms.ValidationMessage<TValue>>(seq);
        __builder.AddAttribute(__seq0, "For", __arg0);
        __builder.CloseComponent();
        }
    }
}
#pragma warning restore 1591
