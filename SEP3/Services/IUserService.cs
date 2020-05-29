using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using SEP3.Data;

namespace SEP3.Services
{
   public interface IUserService
    {
       
           // public Task<User> LogInAsync(User user);

         public  Task<User> LoginAsync(User user);
        public Task<bool> CreateAccAsync(User user);



    }
}
