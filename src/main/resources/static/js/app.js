/**
 * Created by Bijay on 7/3/2016.
 */
(function(){
    var app = angular.module('bookPlus',[]);
    app.controller('BookController',['$http',function($http){
        var url = "";
        var self = this;

        /**** Initial method to set baseurl ****/

        this.initialize = function(baseurl){
            self.url = baseurl;
            self.loadPages();
        }

        //Load the booklist initially
        this.loadPages = function(){
            $http.get(self.url + "api/book/all").success(function(data) {
                    self.books = data;

                });
        }

        this.deleteBook = function(id){
            if(!confirm("Deleting... ?")) return;
            $http.get(self.url + "api/book/delete/" + id).success(function(){
                self.loadPages();
            });
        }

    }]);
})();
