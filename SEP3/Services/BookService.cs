using System;
using System.Linq;
using System.Threading.Tasks;
using SEP3.Data;

namespace SEP3.Services

{
    public class BookService
    {
        private static readonly string[] Titles = new[]
       {
            "LOTR", "Harry Potter", "Game of Thrones", "MArvel Comics", "Gone with the wind"
        };
        public Task<Book[]> GetAllBookAsync()
        {
            var rng = new Random();
            return Task.FromResult(Enumerable.Range(1, 5).Select(index => new Book
            {
                Name = Titles[rng.Next(0, 4)]
            }).ToArray());
        }
    }
}
