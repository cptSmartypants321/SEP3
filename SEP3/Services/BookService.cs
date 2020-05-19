using System;
using System.Linq;
using System.Threading.Tasks;
using SEP3.Data;

namespace SEP3.Services

{
    public class BookService
    {
        private static readonly string[] Authors = new[]
          {
            "IDK", "JK", "OJ", "BoJack", "Rick", "Will", "Jenga", "Ray", "Pyro", "Jack"
        };
        private static readonly string[] Titles = new[]
       {
            "LOTR", "Harry Potter", "Game of Thrones", "MArvel Comics", "Gone with the wind"
        };
        public Task<Book[]> GetAllBookAsync()
        {
            var rng = new Random();
            return Task.FromResult(Enumerable.Range(1, 5).Select(index => new Book
            {
                Author = Authors[rng.Next(0, 9)],
                Title = Titles[rng.Next(0, 4)]
            }).ToArray());
        }
    }
}
