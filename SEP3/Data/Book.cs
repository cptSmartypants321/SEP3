using System;
using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;
using Newtonsoft.Json;


namespace SEP3.Data
{
    public class Book
    {
    [Required]
        public String Title{ get; set; }
        [Required]
        public String Author { get; set; }
       
        public Object getJson(string temp)
        {
             return JsonConvert.DeserializeObject(temp);

        }
       
    }
}
