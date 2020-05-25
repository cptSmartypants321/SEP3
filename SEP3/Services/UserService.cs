using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Net.Http;
using SEP3.Data;
using Newtonsoft.Json;


namespace SEP3.Services
{   
    public class UserService : IUserService
    {
        public HttpClient httpClient;
        
        
        public UserService()
        {
            httpClient = new HttpClient();
            //link to api 
            httpClient.BaseAddress = new Uri("http://localhost:8080/");
        }
        public bool Login(User user)
        {
            return true;
        }
        public async Task<bool> LoginAsync(User user)
        {
            Console.WriteLine($"***************** Sent log in info ********");
            HttpRequestMessage request = new HttpRequestMessage(HttpMethod.Post, "OnlineLibrary/login");
            Console.WriteLine($"***************** Sent log in info 1**********");
            string serUser = $"" + user.Name + ":" + user.Password;                                      // JsonConvert.SerializeObject(user);
                                                                                                         // Account serUser= new Account(user.Name,user.Password,null)
            Console.WriteLine($"***************** Sent log in info 2**********");
            request.Content = new StringContent(serUser);
            Console.WriteLine($"***************** Sent log in info 3**********" + serUser);
            //sending req
           var t=await httpClient.SendAsync(request);
            Console.WriteLine($"***************** Sent log in info 4**********");
            HttpResponseMessage response = await httpClient.GetAsync("http://localhost:8080/OnlineLibrary/login");
            Console.WriteLine("RESPONSE: ");
            string responseBody = await response.Content.ReadAsStringAsync();
            Console.WriteLine(responseBody);
            return true;
        }
        public async Task<bool> CreateAccAsync(User user)
        {
            
            HttpRequestMessage request = new HttpRequestMessage(HttpMethod.Post, "OnlineLibrary/createAcc");
            string serUser = $"" + user.Name + ":" + user.Email+":"+user.Password;                                     
            request.Content = new StringContent(serUser);
            //sendings
            
            var sentReq = await httpClient.SendAsync(request);
            // recieving 
            HttpResponseMessage response = await httpClient.GetAsync("http://localhost:8080/OnlineLibrary/createAcc");
            Console.WriteLine("RESPONSE: ");
            string responseBody = await response.Content.ReadAsStringAsync();
            Console.WriteLine(responseBody);
            return true;
        }

    }
}
