using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;

namespace SEP3.Data
{
    public partial class User
    {
        [Required]
        public String Name { get; set; }
        [Range(8, 16, ErrorMessage = "Password should be from 8 to 16 characters long. ")]
        public String Password { get; set; }
    }
}
