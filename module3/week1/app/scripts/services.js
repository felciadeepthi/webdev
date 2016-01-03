'use strict';

angular.module('confusionApp')
  .constant("baseURL", "http://localhost:3000/")

.service('menuFactory', ['$resource', 'baseURL', function ($resource, baseURL) {


  this.getDishes = function () {

    return $resource(baseURL + "dishes/:id", null, {
      'update': {
        method: 'PUT'
      }
    });
  };


  this.getPromotion = function () {
    // return promotions[index];
    return $resource(baseURL + "promotions/:id", null, {
      method: 'GET'
    });

  }

  // implement a function named getPromotion
  // that returns a selected promotion.


}])

.factory('corporateFactory', ['$resource', 'baseURL', function ($resource, baseURL) {

  var corpfac = {};


  corpfac.getLeaders = function () {
    return $resource(baseURL + "leadership/:id", null, {
      method: 'GET'
    });
  }

  return corpfac;

}])

.factory('feedbackFactory', ['$resource', 'baseURL', function ($resource, baseURL) {
  var feedbackfac = {};

  feedbackfac.getFeedback = function () {
    return $resource(baseURL + "feedback/:id", null, {
      method: 'POST'
    });
  }

  return feedbackfac;

}])

;