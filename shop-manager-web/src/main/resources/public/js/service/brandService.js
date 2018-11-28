app.service("brandService", function ($http) {
    var brandUrl = baseUrl + "brand/";
    this.search = function (page, size,searchEntity) {
        return $http.post(brandUrl + 'search?page=' + page + '&size=' + size, searchEntity)
    };
    this.add = function (brand) {
        return $http.post(brandUrl+ 'add', brand)
    };
    this.update = function (brand) {
        return $http.post(brandUrl + "update", brand)
    };
    this.findOne = function (id) {
        return $http.get(brandUrl + 'findById/' + id)
    };
    this.delete = function (selectIds) {
        return $http.get(brandUrl + 'delete/' + selectIds.toString())
    }
})