using Microsoft.AspNetCore.Components.Authorization;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Blazored.SessionStorage;
using System.Security.Claims;

namespace SEP3.Data
{
    public class CustomAuthenticationStateProvider : AuthenticationStateProvider
    {
        private ISessionStorageService sessionStorage;

        public CustomAuthenticationStateProvider(ISessionStorageService _sessionStorage)
        {
           sessionStorage = _sessionStorage;
        }


        public override async Task<AuthenticationState> GetAuthenticationStateAsync()
        {
            var username = await sessionStorage.GetItemAsync<string>("username");
            ClaimsIdentity identity;
            if (username != null)
            {
                identity = new ClaimsIdentity(new[]
                 {
                 new Claim(ClaimTypes.Name,username),
                 }, "apiauth_type");
            }
            else
            {
                identity = new ClaimsIdentity();
            }
            var user = new ClaimsPrincipal(identity);
            return await Task.FromResult(new AuthenticationState(user));
        }

        public void MarkUserAsAuthenticated(User returnedUser)
        {
            ClaimsIdentity identity=GetClaimsIdentity(returnedUser);
            if (returnedUser.admin)
            {
                Console.WriteLine("I am ADMIN");
                identity.AddClaim(new Claim(ClaimTypes.Role, "admin"));
            }
            var user = new ClaimsPrincipal(identity);
            NotifyAuthenticationStateChanged(Task.FromResult(new AuthenticationState(user)));
        }
        private ClaimsIdentity GetClaimsIdentity(User user)
        {
            var identity = new ClaimsIdentity(new[]
             {
             new Claim(ClaimTypes.Name,user.username),
             }, "apiauth_type");
            return identity;
        }
    }
}
