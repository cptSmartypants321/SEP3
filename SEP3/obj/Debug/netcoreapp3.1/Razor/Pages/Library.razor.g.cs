#pragma checksum "C:\Users\mathi\OneDrive\Dokumenter\GitHub\SEP3\SEP3\Pages\Library.razor" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "db4641e34e5fa799587cd6a7fb327e8e18eab1bd"
// <auto-generated/>
#pragma warning disable 1591
namespace SEP3.Pages
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Components;
#nullable restore
#line 1 "C:\Users\mathi\OneDrive\Dokumenter\GitHub\SEP3\SEP3\_Imports.razor"
using System.Net.Http;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\mathi\OneDrive\Dokumenter\GitHub\SEP3\SEP3\_Imports.razor"
using Microsoft.AspNetCore.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "C:\Users\mathi\OneDrive\Dokumenter\GitHub\SEP3\SEP3\_Imports.razor"
using Microsoft.AspNetCore.Components.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 4 "C:\Users\mathi\OneDrive\Dokumenter\GitHub\SEP3\SEP3\_Imports.razor"
using Microsoft.AspNetCore.Components.Forms;

#line default
#line hidden
#nullable disable
#nullable restore
#line 5 "C:\Users\mathi\OneDrive\Dokumenter\GitHub\SEP3\SEP3\_Imports.razor"
using Microsoft.AspNetCore.Components.Routing;

#line default
#line hidden
#nullable disable
#nullable restore
#line 6 "C:\Users\mathi\OneDrive\Dokumenter\GitHub\SEP3\SEP3\_Imports.razor"
using Microsoft.AspNetCore.Components.Web;

#line default
#line hidden
#nullable disable
#nullable restore
#line 7 "C:\Users\mathi\OneDrive\Dokumenter\GitHub\SEP3\SEP3\_Imports.razor"
using Microsoft.JSInterop;

#line default
#line hidden
#nullable disable
#nullable restore
#line 8 "C:\Users\mathi\OneDrive\Dokumenter\GitHub\SEP3\SEP3\_Imports.razor"
using SEP3;

#line default
#line hidden
#nullable disable
#nullable restore
#line 9 "C:\Users\mathi\OneDrive\Dokumenter\GitHub\SEP3\SEP3\_Imports.razor"
using SEP3.Shared;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\mathi\OneDrive\Dokumenter\GitHub\SEP3\SEP3\Pages\Library.razor"
using SEP3.Data;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "C:\Users\mathi\OneDrive\Dokumenter\GitHub\SEP3\SEP3\Pages\Library.razor"
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
            __builder.OpenElement(0, "div");
            __builder.AddAttribute(1, "class", "col-12");
            __builder.AddMarkupContent(2, "\r\n    ");
            __builder.AddMarkupContent(3, "<h3><b>Enter Book Information</b></h3>\r\n    <hr>\r\n\r\n\r\n    ");
            __builder.OpenComponent<Microsoft.AspNetCore.Components.Forms.EditForm>(4);
            __builder.AddAttribute(5, "Model", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.Object>(
#nullable restore
#line 12 "C:\Users\mathi\OneDrive\Dokumenter\GitHub\SEP3\SEP3\Pages\Library.razor"
                      book

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(6, "OnValidSubmit", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<Microsoft.AspNetCore.Components.EventCallback<Microsoft.AspNetCore.Components.Forms.EditContext>>(Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.Forms.EditContext>(this, 
#nullable restore
#line 12 "C:\Users\mathi\OneDrive\Dokumenter\GitHub\SEP3\SEP3\Pages\Library.razor"
                                            SaveBook

#line default
#line hidden
#nullable disable
            )));
            __builder.AddAttribute(7, "ChildContent", (Microsoft.AspNetCore.Components.RenderFragment<Microsoft.AspNetCore.Components.Forms.EditContext>)((context) => (__builder2) => {
                __builder2.AddMarkupContent(8, "\r\n        ");
                __builder2.OpenComponent<Microsoft.AspNetCore.Components.Forms.DataAnnotationsValidator>(9);
                __builder2.CloseComponent();
                __builder2.AddMarkupContent(10, "\r\n\r\n        ");
                __builder2.OpenElement(11, "div");
                __builder2.AddAttribute(12, "class", "col-12 row");
                __builder2.AddMarkupContent(13, "\r\n            ");
                __builder2.AddMarkupContent(14, "<label class=\"col-2 font-weight-bold\">Title : </label>\r\n            ");
                __builder2.OpenComponent<Microsoft.AspNetCore.Components.Forms.InputText>(15);
                __builder2.AddAttribute(16, "class", "form-control col-3");
                __builder2.AddAttribute(17, "placeholder", "title");
                __builder2.AddAttribute(18, "Value", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.String>(
#nullable restore
#line 17 "C:\Users\mathi\OneDrive\Dokumenter\GitHub\SEP3\SEP3\Pages\Library.razor"
                                                               book.Name

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(19, "ValueChanged", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<Microsoft.AspNetCore.Components.EventCallback<System.String>>(Microsoft.AspNetCore.Components.EventCallback.Factory.Create<System.String>(this, Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.CreateInferredEventCallback(this, __value => book.Name = __value, book.Name))));
                __builder2.AddAttribute(20, "ValueExpression", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.Linq.Expressions.Expression<System.Func<System.String>>>(() => book.Name));
                __builder2.CloseComponent();
                __builder2.AddMarkupContent(21, "\r\n            &nbsp;");
                __Blazor.SEP3.Pages.Library.TypeInference.CreateValidationMessage_0(__builder2, 22, 23, 
#nullable restore
#line 18 "C:\Users\mathi\OneDrive\Dokumenter\GitHub\SEP3\SEP3\Pages\Library.razor"
                                            () => book.Name

#line default
#line hidden
#nullable disable
                );
                __builder2.AddMarkupContent(24, "\r\n        ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(25, "\r\n        <br>\r\n       \r\n        <br>\r\n        ");
                __builder2.AddMarkupContent(26, @"<div class=""col-12 row"">
            <span class=""col-2""></span>
            <input type=""submit"" class=""form-control col-1 btn btn-primary"" value=""Save"">
            <span>&nbsp;</span>
            <input type=""submit"" class=""form-control col-1 btn btn-primary"" value=""Clear"">
        </div>
    ");
            }
            ));
            __builder.CloseComponent();
            __builder.AddMarkupContent(27, "\r\n");
            __builder.CloseElement();
            __builder.AddMarkupContent(28, "\r\n<br>\r\n<br>\r\n");
            __builder.AddMarkupContent(29, "<h2 class=\"font-weight-bolder font-italic\">Your List of Books</h2>\r\n");
            __builder.OpenElement(30, "table");
            __builder.AddAttribute(31, "class", "table");
            __builder.AddMarkupContent(32, "\r\n    ");
            __builder.AddMarkupContent(33, "<thead>\r\n        <tr>\r\n            <th>Title of Book</th>\r\n            <th>Author</th>\r\n        </tr>\r\n    </thead>\r\n    ");
            __builder.OpenElement(34, "tbody");
            __builder.AddMarkupContent(35, "\r\n");
#nullable restore
#line 42 "C:\Users\mathi\OneDrive\Dokumenter\GitHub\SEP3\SEP3\Pages\Library.razor"
         if (bookList != null)
        {
            foreach (var book in bookList)
            {

#line default
#line hidden
#nullable disable
            __builder.AddContent(36, "                ");
            __builder.OpenElement(37, "tr");
            __builder.AddMarkupContent(38, "\r\n                    ");
            __builder.OpenElement(39, "td");
            __builder.AddContent(40, 
#nullable restore
#line 47 "C:\Users\mathi\OneDrive\Dokumenter\GitHub\SEP3\SEP3\Pages\Library.razor"
                         book.Name

#line default
#line hidden
#nullable disable
            );
            __builder.CloseElement();
            __builder.AddMarkupContent(41, "\r\n                    \r\n\r\n                ");
            __builder.CloseElement();
            __builder.AddMarkupContent(42, "\r\n");
#nullable restore
#line 51 "C:\Users\mathi\OneDrive\Dokumenter\GitHub\SEP3\SEP3\Pages\Library.razor"
            }
        }

#line default
#line hidden
#nullable disable
            __builder.AddMarkupContent(43, "\r\n    ");
            __builder.CloseElement();
            __builder.AddMarkupContent(44, "\r\n");
            __builder.CloseElement();
        }
        #pragma warning restore 1998
#nullable restore
#line 58 "C:\Users\mathi\OneDrive\Dokumenter\GitHub\SEP3\SEP3\Pages\Library.razor"
       

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
        Console.WriteLine("THIS IS THE PLACE");

        Console.WriteLine(response.IsSuccessStatusCode);
        string responseBody = await response.Content.ReadAsStringAsync();
        var print = book.GetJson(responseBody);
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
namespace __Blazor.SEP3.Pages.Library
{
    #line hidden
    internal static class TypeInference
    {
        public static void CreateValidationMessage_0<TValue>(global::Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder, int seq, int __seq0, global::System.Linq.Expressions.Expression<global::System.Func<TValue>> __arg0)
        {
        __builder.OpenComponent<global::Microsoft.AspNetCore.Components.Forms.ValidationMessage<TValue>>(seq);
        __builder.AddAttribute(__seq0, "For", __arg0);
        __builder.CloseComponent();
        }
    }
}
#pragma warning restore 1591
