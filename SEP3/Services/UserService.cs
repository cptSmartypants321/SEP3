using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Net.Http;
using SEP3.Data;
using SEP3.Services;
using System.Text.Json;
using System.Text.Json.Serialization;
using SEP3.Pages;

namespace SEP3.Services
{
    public class UserService : IUserService
    {
        public HttpClient httpClient;
        private Boolean b;
        public UserService(HttpClient httpClient)
        {
            this.httpClient = httpClient;
        }
        public async Task<bool> CreateAccAsync(User user)
        {
            HttpRequestMessage request = new HttpRequestMessage(HttpMethod.Post, "OnlineLibrary/createAcc");
            string serUser = $"" + user.username + ":" + user.password + ":" + user.email;
            request.Content = new StringContent(serUser);
            //var sentReq = await httpClient.SendAsync(request);
            httpClient.SendAsync(request);
            return true;
        }


        public async Task<User> LoginAsync(User user)
        {
            HttpRequestMessage request = new HttpRequestMessage(HttpMethod.Post, "OnlineLibrary/login");
            string serUser = $"" + user.username + ":" + user.password;                                      // JsonConvert.SerializeObject(user);
            request.Content = new StringContent(serUser);
            HttpResponseMessage response = await httpClient.SendAsync(request);

            string responseBody = await response.Content.ReadAsStringAsync();
            User userRecieved = JsonSerializer.Deserialize<User>(responseBody);
            Console.WriteLine("Response 2: " + responseBody + "USer recieved : " + userRecieved.username + " "+userRecieved.password + " " + userRecieved.email + " "+ userRecieved.admin);
            return userRecieved;
        }
            
    }
}
