using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using SEP3.Data;

namespace SEP3.Services
{
   public interface IUserService
    {
       
            public Task<User> LoginAsync(User user);
            
        
    }
}
