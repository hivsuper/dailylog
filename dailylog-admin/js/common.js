var v={
    apiHost : 'http://127.0.0.1:8080/dailylog/',
    go : function(url) {
        if(url.indexOf("/")==0) {
            layer.alert('Do not use url which start with /');
        }else{
            top.location.href = this._getRootPath_dc() + '/' + url;
        }
    },
    _getRootPath_dc : function() {
        var pathName = top.location.pathname.substring(1);
        var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
        if (webName == "") {
            return top.location.protocol + '//' + top.location.host;
        } else {
            return top.location.protocol + '//' + top.location.host + '/' + webName;
        }
    },
    isEmpty : function(str) {
        return $.trim(str).length==0;
    },
    heartBeat : function(success) {
        this.ajaxGetJsonResult(this.apiHost + 'heartBeat.json', undefined, success, undefined, false);
    },
    logout: function() {
        var that = this;
        this.ajaxGetJsonResult(that.apiHost + 'logout.json', undefined, function(){
            that._delete('dailylog_admin_user');
            that.go('login.html');
        }, undefined, false);
    },
    ajaxGetJsonResult: function(url, data, success, error, shade) {
        var option = this.createOption(url, 'get', data, success, error, true, shade);
        $.ajax(option);
    },
    ajaxPostJsonResult: function(url, data, success, error, shade) {
        var option = this.createOption(url, 'post', data, success, error, true, shade);
        $.ajax(option);
    },
    createOption: function(url, type, data, success, error, async, shade) {
        if (shade == undefined || shade == null || shade) {
            layer.load(1, {
                shade: [0.6, '#000'] //0.6透明度的白色背景
            });
        }
        var that = this;
        var option = {
            url: url,
            data: data || {},
            type: type || 'post',
            dataType: 'json',
            cache: false,
            async: async || false,
            xhrFields: {
                withCredentials: true
            },
            complete: function() {
                layer.closeAll('loading');
            },
            success: function(json) {
                var code = json.code;
                if (200 == code) {
                    var data = json.content;
                    success(data);
                } else if (403 == code) {
                    that.go('login.html');
                } else {
                    if (error) {
                        error(code);
                    } else {
                        alert('Error Code=' + code);
                    }
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
            }
        };
        return option;
    },
    _writeJson: function(key, json) {
        localStorage.setItem(key, JSON.stringify(json));
    },
    _getJson: function(key) {
        return localStorage.getItem(key);
    },
    _delete: function(key) {
        return localStorage.removeItem(key);
    },
    getUser: function() {
        return eval("(" + this._getJson('dailylog_admin_user') + ")");
    },
    setUser: function(user) {
        return this._writeJson('dailylog_admin_user', user);
    }
}
if($('#logoutModal')){
    $('#logoutModal').html(
        '<div class="modal-dialog" role="document"><div class="modal-content"><div class="modal-header"><h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>'+
        '<button class="close" type="button" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button></div>'+
        '<div class="modal-body">Select "Logout" below if you are ready to end your current session.</div><div class="modal-footer">'+
        '<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button><a class="btn btn-primary" href="javascript:;">Logout</a></div></div></div>'
    );
    $('#logoutModal').on('click', '.btn-primary', function(){
        v.logout();
    });
}
if($('footer.sticky-footer')){
    $('footer.sticky-footer').html('<div class="container"><div class="text-center"><small>Copyright © Your Website 2018</small></div></div>');
}