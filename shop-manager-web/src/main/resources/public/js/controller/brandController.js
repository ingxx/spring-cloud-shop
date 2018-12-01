app.controller('brandController', function ($scope, $http, $controller, brandService) {

    $controller('baseController', {$scope: $scope});

    $scope.searchEntity = {};
    $scope.search = function (page, size) {
        brandService.search(page, size, $scope.searchEntity).success(
            function (data) {
                $scope.list = data.data.rows;
                $scope.paginationConf.totalItems = data.data.total;
            })
    };
    $scope.save = function () {
        if ($scope.brand.id == null) {
            brandService.add($scope.brand).success(
                function (data) {
                    if (data.status == 200) {
                        $scope.reloadList();
                    } else {
                        console.log("增加失败")
                    }
                })
        } else {
            brandService.update($scope.brand).success(
                function (data) {
                    if (data.status == 200) {
                        $scope.reloadList();
                    } else {
                        console.log("更新失败")
                    }
                }
            )
        }
        $scope.brand = null;
    };
    $scope.findOne = function (id) {
        brandService.findOne(id).success(
            function (data) {
                if (data.status == 200) {
                    $scope.brand = data.data;
                } else {
                    console.log("更新失败");
                }
            })
    };

    $scope.delete = function () {
        brandService.delete($scope.selectIds).success(
            function (data) {
                if (data.status == 200) {
                    $scope.reloadList();
                } else {
                    console.log("删除失败")
                }
            }
        )
    };
});