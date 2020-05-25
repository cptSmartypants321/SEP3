using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;

namespace SEP3.Data
{
    public partial class User
    {
        [Required(ErrorMessage="Username is required.")]
        public String Name { get; set; }
        //[DataType(DataType:EmailAddressAttribute)]
        [EmailAddress(ErrorMessage="Please enter a valid e-mail address.")]
        public String Email { get; set; }
       
        //[Range(2,99999, ErrorMessage = "Password should be more than 2 characters long. ")]
        public String Password { get; set; }
        
        public String ConfPass { get; set; }
    }
}
