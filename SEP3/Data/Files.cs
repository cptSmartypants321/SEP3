using System;
using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;
using Newtonsoft.Json;
using Microsoft.AspNetCore.Builder;

namespace SEP3.Data
{
    public class Files
    {
    [Required]
        public String filename{ get; set; }

        public string username { get; set; }
        [Required]
        public string uploadDate { get; set; }


        public String format { get; set; }
        public int filesize { get; set; }
        public String path { get; set; }

        public int rating { get; set; }
        public string category { get; set; }

        

        public byte[] mybytearray { get; set; }

        
       
    }
}
