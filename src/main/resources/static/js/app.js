/**
 * Created by Bijay on 7/3/2016.
 */
(function(){
    var app = angular.module('bookPlus',[]);
    app.controller('BookController',['$http',function($http){

        /*******Global Properties *********/
        var url = "";
        var self = this;

        /*********Book Only Properties ********/
        var quantity; //quantity to hold the product copy


        /**** Initial method to set baseurl ****/

        this.initialize = function(baseurl){
            self.url = baseurl;
            self.loadBooks();
            self.loadCategories();
        }


        /**** BOOK SPECIFIC *************/

        //Load the booklist initially
        this.loadBooks = function(){
            $http.get(self.url + "api/book/all").success(function(data) {
                    self.books = data;

                });
        }

        this.deleteBook = function(id){
            if(!confirm("Deleting... ?")) return;
            $http.get(self.url + "api/book/delete/" + id).success(function(){
                self.loadBooks();
            });
        }

        this.getBookCopy = function(bookid){
            self.quantity = bookid;
            console.log("Quantity: " + self.quantity);
            $http.get(self.url + "api/book/copy/" + bookid).success(function(){
               //self.loadBooks();
            });
        }

        /*********End of Book Specific **********/

        /********* CATEGORY SPECIFIC ****************/
        //Load the booklist initially
        this.loadCategories = function(){
            console.log("I am here");
            $http.get(self.url + "api/category/all").success(function(data) {
                self.categories = data;

            });
        }

        /***** Delete Category ****/
        this.deleteCategory = function(id){
            if(!confirm("Deleting... ?")) return;
            $http.get(self.url + "api/category/delete/" + id).success(function(){
                self.loadCategories();
            });
        }
        /********* End of category Specific **********/

    }]);
})();
