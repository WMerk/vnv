vnvApp.service('userService',
    [
        '$cookies', 'doCheckLogin', '$location',
        function ($cookies, doCheckLogin, $location) {
            var currentUser = null;
            var newUser = false;
            var offerCreated = false;
            var requestCreated = false;
            var accountDeleted = false;
            var googleLogin = false;

            var navigationTemplate = 'html/templates/navigation.html';

            return {
                getCurrentUser: function () {
                    if (currentUser == null) {
                        currentUser = $cookies.getObject('currentUser');
                    }
                    var params = {};
                    // check if still null
                    if (!googleLogin && currentUser == null) {
                        $location.path('/Login');
                    }
                    else {
                        params['uid'] = currentUser.uid;
                    }
                    if(googleLogin){
                        return currentUser;
                    }
                    var response = doCheckLogin.query(params);
                    response.$promise.then(function (data) {
                        if (data.error !== undefined) {
                            // error
                            $location.path('/Login');
                        }
                    }).catch(function (response) {
                        $location.path('/Login');
                    });
                    return currentUser;
                },
                setCurrentUser: function (value) {
                    $cookies.putObject('currentUser', value);
                    currentUser = value;
                },
                getNewUser: function () {
                    return newUser;
                },
                setNewUser: function (value) {
                    newUser = value;
                },
                getOfferCreated: function () {
                    return offerCreated;
                },
                setOfferCreated: function (value) {
                    offerCreated = value;
                },
                getRequestCreated: function () {
                    return requestCreated;
                },
                setRequestCreated: function (value) {
                    requestCreated = value;
                },
                getNavigationTemplate: function () {
                    return navigationTemplate;
                },
                setAccountDeleted: function (value) {
                    accountDeleted = value;
                },
                getAccountDeleted: function () {
                    return accountDeleted;
                },
                clearData: function () {
                    this.setCurrentUser(null);
                },
                setGoogleLogin: function (value) {
                    googleLogin = value;
                },
            };

        }]);