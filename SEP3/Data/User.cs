using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;

namespace SEP3.Data
{
    public partial class User
    {
        [Required(ErrorMessage = "username is required.")]
        public String username { get; set; }
        //[Range(2,99999, ErrorMessage = "password should be more than 2 characters long. ")]
        [Required(ErrorMessage = "Password is required.")]
        public String password { get; set; }
        //[DataType(DataType:EmailAddressAttribute)]
        [EmailAddress(ErrorMessage = "Please enter a valid e-mail address.")]
        public String email { get; set; }
        public bool admin { get; set; }


    }
}
