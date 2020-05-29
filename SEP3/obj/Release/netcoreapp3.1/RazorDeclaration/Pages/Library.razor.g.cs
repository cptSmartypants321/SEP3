#pragma checksum "C:\Users\jakob\OneDrive\Documents\GitHub\SEP3\SEP3\Pages\Library.razor" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "a8cd14ece72014babcce35d7395305b434031537"
// <auto-generated/>
#pragma warning disable 1591
#pragma warning disable 0414
#pragma warning disable 0649
#pragma warning disable 0169

namespace SEP3.Pages
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Components;
#nullable restore
#line 1 "C:\Users\jakob\OneDrive\Documents\GitHub\SEP3\SEP3\_Imports.razor"
using System.Net.Http;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\jakob\OneDrive\Documents\GitHub\SEP3\SEP3\_Imports.razor"
using Microsoft.AspNetCore.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "C:\Users\jakob\OneDrive\Documents\GitHub\SEP3\SEP3\_Imports.razor"
using Microsoft.AspNetCore.Components.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 4 "C:\Users\jakob\OneDrive\Documents\GitHub\SEP3\SEP3\_Imports.razor"
using Microsoft.AspNetCore.Components.Forms;

#line default
#line hidden
#nullable disable
#nullable restore
#line 5 "C:\Users\jakob\OneDrive\Documents\GitHub\SEP3\SEP3\_Imports.razor"
using Microsoft.AspNetCore.Components.Routing;

#line default
#line hidden
#nullable disable
#nullable restore
#line 6 "C:\Users\jakob\OneDrive\Documents\GitHub\SEP3\SEP3\_Imports.razor"
using Microsoft.AspNetCore.Components.Web;

#line default
#line hidden
#nullable disable
#nullable restore
#line 7 "C:\Users\jakob\OneDrive\Documents\GitHub\SEP3\SEP3\_Imports.razor"
using Microsoft.JSInterop;

#line default
#line hidden
#nullable disable
#nullable restore
#line 8 "C:\Users\jakob\OneDrive\Documents\GitHub\SEP3\SEP3\_Imports.razor"
using SEP3;

#line default
#line hidden
#nullable disable
#nullable restore
#line 9 "C:\Users\jakob\OneDrive\Documents\GitHub\SEP3\SEP3\_Imports.razor"
using SEP3.Shared;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\jakob\OneDrive\Documents\GitHub\SEP3\SEP3\Pages\Library.razor"
using SEP3.Data;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "C:\Users\jakob\OneDrive\Documents\GitHub\SEP3\SEP3\Pages\Library.razor"
using SEP3.Services;

#line default
#line hidden
#nullable disable
    [Microsoft.AspNetCore.Components.RouteAttribute("/library")]
    public partial class Library : Microsoft.AspNetCore.Components.ComponentBase
    {
        #pragma warning disable 1998
        protected override void BuildRenderTree(Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder)
        {
        }
        #pragma warning restore 1998
#nullable restore
#line 58 "C:\Users\jakob\OneDrive\Documents\GitHub\SEP3\SEP3\Pages\Library.razor"
       

    public Book book { get; set; }
    public List<Book> bookList;


    protected override async Task OnInitializedAsync()
    {

        book = new Book();
        Book[] temp = await bookServce.GetAllBookAsync();
       
        bookList = new List<Book>();
        foreach (var bookarr in temp)
        {
            bookList.Add(bookarr);
        };
         HttpResponseMessage response = await httpClient.GetAsync("http://localhost:8080/OnlineLibrary/");
        Console.WriteLine(response.IsSuccessStatusCode);
        string responseBody = await response.Content.ReadAsStringAsync();
        var print = book.getJson(responseBody);
        Console.WriteLine(print.ToString());
    }

    public void SaveBook()
    {
        var title = book.Name;
        Book temp = new Book();
        temp.Name = title;
        bookList.Add(temp);
        book = new Book();

    }


#line default
#line hidden
#nullable disable
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private SEP3.Services.BookService bookServce { get; set; }
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private HttpClient httpClient { get; set; }
    }
}
#pragma warning restore 1591
