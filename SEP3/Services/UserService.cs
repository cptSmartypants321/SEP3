using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Net.Http;
using SEP3.Data;

namespace SEP3.Services
{   
    public class UserService : IUserService
    {
        public HttpClient httpClient;
        
        public UserService()
        {
            
        }
       public bool Login()
        {
            return true;
        }
       // public Task<User> LogInAsync(User user)
       // {

       // }

    }
}
