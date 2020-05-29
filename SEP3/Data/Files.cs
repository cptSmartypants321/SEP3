using System;
using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;
using Newtonsoft.Json;

namespace SEP3.Data
{
    public class Files
    {
    [Required]
        public String Filename{ get; set; }
        [Required]
        public DateTime Date { get; set; }

        public User Username { get; set; }

        public String Path { get; set; }

        public String Format { get; set; }


        public int Filesize{ get; set; }

        public int Rating { get; set; }

        private bool math = false;
        private bool physics = false;
        private bool chemistry = false;
        private bool geography = false;
        private bool literature = false;
        private bool construction = false;
        private bool marketing = false;


        public byte[] ByteArray { get; set; }

        public Object getJson(string temp)
        {
             return JsonConvert.DeserializeObject(temp);

        }
       
    }
}
