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
        public String Name{ get; set; }
        [Required]
        public Category Category { get; set; }

        public byte[] ByteArray { get; set; }

        public DateTime Date { get; set; }
       public String Type { get; set; }
        public int Size { get; set; }
        public User Owner { get; set; }
        public string FileID { get; set; }
        public Object getJson(string temp)
        {
             return JsonConvert.DeserializeObject(temp);

        }
       
    }
}
