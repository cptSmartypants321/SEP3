#pragma checksum "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\Pages\Admin.razor" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "92d2cb60d0afc9e0c0d29805c9b318d0923ec9ab"
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
#line 1 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\_Imports.razor"
using System.Net.Http;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\_Imports.razor"
using Microsoft.AspNetCore.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\_Imports.razor"
using Microsoft.AspNetCore.Components.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 4 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\_Imports.razor"
using Microsoft.AspNetCore.Components.Forms;

#line default
#line hidden
#nullable disable
#nullable restore
#line 5 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\_Imports.razor"
using Microsoft.AspNetCore.Components.Routing;

#line default
#line hidden
#nullable disable
#nullable restore
#line 6 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\_Imports.razor"
using Microsoft.AspNetCore.Components.Web;

#line default
#line hidden
#nullable disable
#nullable restore
#line 7 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\_Imports.razor"
using Microsoft.JSInterop;

#line default
#line hidden
#nullable disable
#nullable restore
#line 8 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\_Imports.razor"
using SEP3;

#line default
#line hidden
#nullable disable
#nullable restore
#line 9 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\_Imports.razor"
using SEP3.Shared;

#line default
#line hidden
#nullable disable
#nullable restore
#line 10 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\_Imports.razor"
using BlazorInputFile;

#line default
#line hidden
#nullable disable
#nullable restore
#line 11 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\_Imports.razor"
using Radzen;

#line default
#line hidden
#nullable disable
#nullable restore
#line 12 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\_Imports.razor"
using Radzen.Blazor;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\Pages\Admin.razor"
using SEP3.Data;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\Pages\Admin.razor"
using SEP3.Services;

#line default
#line hidden
#nullable disable
    [Microsoft.AspNetCore.Components.RouteAttribute("/admin")]
    public partial class Admin : Microsoft.AspNetCore.Components.ComponentBase
    {
        #pragma warning disable 1998
        protected override void BuildRenderTree(Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder)
        {
            __builder.AddMarkupContent(0, @"<style>
    h2 {
        margin-left: 20px;
    }

    #profile {
        border-radius: 5px;
        border: 4px solid #4267B2;
        margin: 20px;
        padding: 10px;
    }

    #editprofile {
        border-radius: 5px;
        margin: 20px;
        border: 4px solid #4267B2;
        padding: 10px;
    }

    table, th, td {
        border: 2px solid black;
        margin-right: 50px;
    }

    th {
        background-color: #4267B2;
        color: white;
    }
</style>
");
            __builder.OpenComponent<Microsoft.AspNetCore.Components.Forms.EditForm>(1);
            __builder.AddAttribute(2, "Model", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.Object>(
#nullable restore
#line 35 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\Pages\Admin.razor"
                  user

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(3, "OnValidSubmit", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<Microsoft.AspNetCore.Components.EventCallback<Microsoft.AspNetCore.Components.Forms.EditContext>>(Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.Forms.EditContext>(this, 
#nullable restore
#line 35 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\Pages\Admin.razor"
                                        UpdateAccount

#line default
#line hidden
#nullable disable
            )));
            __builder.AddAttribute(4, "ChildContent", (Microsoft.AspNetCore.Components.RenderFragment<Microsoft.AspNetCore.Components.Forms.EditContext>)((context) => (__builder2) => {
                __builder2.AddMarkupContent(5, "\r\n    ");
                __builder2.OpenElement(6, "div");
                __builder2.AddAttribute(7, "style", "left: 50%");
                __builder2.AddAttribute(8, "class", "col-6");
                __builder2.AddMarkupContent(9, "\r\n        ");
                __builder2.OpenComponent<Microsoft.AspNetCore.Components.Forms.InputText>(10);
                __builder2.AddAttribute(11, "class", "form-control");
                __builder2.AddAttribute(12, "placeholder", "Search for users");
                __builder2.AddAttribute(13, "Value", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.String>(
#nullable restore
#line 37 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\Pages\Admin.razor"
                                                     user.username

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(14, "ValueChanged", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<Microsoft.AspNetCore.Components.EventCallback<System.String>>(Microsoft.AspNetCore.Components.EventCallback.Factory.Create<System.String>(this, Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.CreateInferredEventCallback(this, __value => user.username = __value, user.username))));
                __builder2.AddAttribute(15, "ValueExpression", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.Linq.Expressions.Expression<System.Func<System.String>>>(() => user.username));
                __builder2.CloseComponent();
                __builder2.AddMarkupContent(16, "\r\n    ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(17, "\r\n    <br>\r\n    ");
                __builder2.OpenElement(18, "div");
                __builder2.AddAttribute(19, "class", "col-6 row float-right");
                __builder2.AddMarkupContent(20, "\r\n        ");
                __builder2.OpenElement(21, "table");
                __builder2.AddAttribute(22, "class", "table");
                __builder2.AddMarkupContent(23, "\r\n            ");
                __builder2.AddMarkupContent(24, "<thead>\r\n                <tr>\r\n                    <th>Username</th>\r\n                    <th>Email</th>\r\n                </tr>\r\n            </thead>\r\n            ");
                __builder2.OpenElement(25, "tbody");
                __builder2.AddMarkupContent(26, "\r\n");
#nullable restore
#line 49 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\Pages\Admin.razor"
                 if (files != null)
                {
                    foreach (var file in files)
                    {

#line default
#line hidden
#nullable disable
                __builder2.AddContent(27, "                        ");
                __builder2.OpenElement(28, "tr");
                __builder2.AddMarkupContent(29, "\r\n                            ");
                __builder2.OpenElement(30, "td");
                __builder2.AddContent(31, 
#nullable restore
#line 54 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\Pages\Admin.razor"
                                 file.filename

#line default
#line hidden
#nullable disable
                );
                __builder2.CloseElement();
                __builder2.AddMarkupContent(32, "\r\n                            ");
                __builder2.OpenElement(33, "td");
                __builder2.AddContent(34, 
#nullable restore
#line 55 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\Pages\Admin.razor"
                                 file.uploadDate

#line default
#line hidden
#nullable disable
                );
                __builder2.CloseElement();
                __builder2.AddMarkupContent(35, "\r\n                            ");
                __builder2.OpenElement(36, "td");
                __builder2.AddContent(37, 
#nullable restore
#line 56 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\Pages\Admin.razor"
                                 file.rating

#line default
#line hidden
#nullable disable
                );
                __builder2.CloseElement();
                __builder2.AddMarkupContent(38, "\r\n                        ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(39, "\r\n");
#nullable restore
#line 58 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\Pages\Admin.razor"
                    }
                }

#line default
#line hidden
#nullable disable
                __builder2.AddContent(40, "            ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(41, "\r\n        ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(42, "\r\n    ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(43, "\r\n    ");
                __builder2.OpenElement(44, "div");
                __builder2.AddAttribute(45, "id", "editprofile");
                __builder2.AddAttribute(46, "class", "col-4");
                __builder2.AddAttribute(47, "style", "align-content: center");
                __builder2.AddMarkupContent(48, "\r\n        ");
                __builder2.AddMarkupContent(49, "<div>\r\n            <div style=\"text-align:center\">\r\n                <label class=\"font-weight-bold\" style=\"color: #4267B2; font-size:25px; \">Create an Account</label>\r\n            </div>\r\n        </div>\r\n        <br>\r\n        ");
                __builder2.OpenElement(50, "div");
                __builder2.AddMarkupContent(51, "\r\n            ");
                __builder2.AddMarkupContent(52, "<label class=\"font-weight\">Your Current Password </label>\r\n            ");
                __builder2.OpenElement(53, "input");
                __builder2.AddAttribute(54, "type", "password");
                __builder2.AddAttribute(55, "class", "form-control col-8 font-italic");
                __builder2.AddAttribute(56, "style", "left: 15%; text-align: center; ");
                __builder2.AddAttribute(57, "placeholder", "Password");
                __builder2.AddAttribute(58, "value", Microsoft.AspNetCore.Components.BindConverter.FormatValue(
#nullable restore
#line 72 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\Pages\Admin.razor"
                                                                                                                         user.password

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(59, "onchange", Microsoft.AspNetCore.Components.EventCallback.Factory.CreateBinder(this, __value => user.password = __value, user.password));
                __builder2.SetUpdatesAttributeName("value");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(60, "\r\n        ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(61, "\r\n        <br>\r\n        <br>\r\n        ");
                __builder2.OpenElement(62, "div");
                __builder2.AddAttribute(63, "style", true);
                __builder2.AddMarkupContent(64, "\r\n            ");
                __builder2.AddMarkupContent(65, "<label class=\"font-weight\">The New Password </label>\r\n            ");
                __builder2.OpenElement(66, "input");
                __builder2.AddAttribute(67, "type", "password");
                __builder2.AddAttribute(68, "class", "form-control col-8 font-italic");
                __builder2.AddAttribute(69, "style", "left:15%; text-align:center;");
                __builder2.AddAttribute(70, "placeholder", "Password");
                __builder2.AddAttribute(71, "value", Microsoft.AspNetCore.Components.BindConverter.FormatValue(
#nullable restore
#line 78 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\Pages\Admin.razor"
                                                                                                                      user.password

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(72, "onchange", Microsoft.AspNetCore.Components.EventCallback.Factory.CreateBinder(this, __value => user.password = __value, user.password));
                __builder2.SetUpdatesAttributeName("value");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(73, "\r\n        ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(74, "\r\n        <br>\r\n        <br>\r\n        ");
                __builder2.OpenElement(75, "div");
                __builder2.AddMarkupContent(76, "\r\n            ");
                __builder2.AddMarkupContent(77, "<label class=\"font-weight\">The New Email </label>\r\n            ");
                __builder2.OpenElement(78, "input");
                __builder2.AddAttribute(79, "type", "email");
                __builder2.AddAttribute(80, "class", "form-control col-8 font-italic");
                __builder2.AddAttribute(81, "style", "left:15%; text-align:center;");
                __builder2.AddAttribute(82, "placeholder", "My@email.com");
                __builder2.AddAttribute(83, "value", Microsoft.AspNetCore.Components.BindConverter.FormatValue(
#nullable restore
#line 84 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\Pages\Admin.razor"
                                                                                                                   user.email

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(84, "onchange", Microsoft.AspNetCore.Components.EventCallback.Factory.CreateBinder(this, __value => user.email = __value, user.email));
                __builder2.SetUpdatesAttributeName("value");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(85, "\r\n        ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(86, "\r\n        <br>\r\n        ");
                __builder2.AddMarkupContent(87, "<div>\r\n            <label class=\"font-weight\">Admin </label>\r\n            <input type=\"radio\" id=\"isadmin\" name=\"isAdmin\" value=\"admin\">\r\n        </div>\r\n        <br>\r\n        ");
                __builder2.AddMarkupContent(88, "<div class=\"col-6\" style=\"left:23%\">\r\n            <input type=\"submit\" class=\"form-control btn btn-primary\" value=\"Create\">\r\n            <span>&nbsp;</span>\r\n            \r\n            \r\n        </div>\r\n    ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(89, "\r\n");
            }
            ));
            __builder.CloseComponent();
        }
        #pragma warning restore 1998
#nullable restore
#line 100 "C:\Users\mathi\OneDrive\Skrivebord\2020Collection\SEP3\Pages\Admin.razor"
       
    public IList<Files> files;
    public User user;
    public bool isCorrect;
    protected override async Task OnInitializedAsync()
    {
        user = new User();
    }
    public void UpdateAccount()
    {
    }
    private async Task<bool> createAccountPage()
    {
        Console.WriteLine("*************** USER ACCOUNT CREATE******************");
        return await Task.FromResult(true);
    }

#line default
#line hidden
#nullable disable
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private NavigationManager navManager { get; set; }
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private IUserService userService { get; set; }
    }
}
#pragma warning restore 1591
