Ext.onReady(function() {
	Ext.require([ 'Ext.form.*', 'Ext.window.Window', 'fms.ux.VerifyCode' ]);
	var vefiryCode=Ext.create('fms.ux.VerifyCode', {
	    fieldLabel:'VerifyCode',
	    name:'verifycode',
	    id:'verifycode',
	    blankText:"Can't be blank",
	    codeImgUrl:'kaptcha.jpg',
	    tabIndex:3,
	    width:'60%',//same as anchor
	    refresh:function(){
	    	this.onImgClick();
		}
	});
	var field = new Ext.form.field.Text({
		renderTo : document.body,
		layout: {//设置容器字段布局
			type: 'hbox',
			align: 'middle'//垂直居中
		}
	}), padding = 50;

	field.destroy();
	var form = new Ext.form.Panel({
		border : false,
		fieldDefaults : {
			labelWidth : 65
		},
		defaultType : 'textfield',
		bodyPadding : padding,

		items : [ {
			fieldLabel: 'UserName',
			name: 'account',
			minLength: 5,
			maxLength: 25,
			allowBlank: false,
			anchor : '60%',
			vtype: 'email', 
			emptyText: 'user@example.com',  
            blankText: 'Please input valid username' 
		}, {
			fieldLabel: 'PassWord',
			name: 'passwd',
			minLength: 5,
			maxLength: 32,
			inputType: 'password',
			allowBlank: false,
			anchor : '60%'
		}, vefiryCode]
	});
	new Ext.window.Window({
		draggable : false,
		closable : false,
		resizable : false,
		autoShow : true,
		title : 'Login Window',
		width : 500,
		height : 300,
		layout : 'fit',
		plain : true,
		items : [form],
		buttons : [ {
			text : 'Login', handler:function(){
				if(form.getForm().isValid()){
					this.disabled=true;
					var f=this;
					form.getForm().findField('passwd').setValue(CryptoJS.MD5(form.getForm().findField('passwd').getValue()));
					form.getForm().submit({
						url:loginUrl,
						method:'post',
						waitTitle:'Loading...',
						waitMsg:'Loading...',
						success:function(fm, o){
							if(o.result.success=='true'){
								window.location.href=nextUrl;
							}else{
								Ext.Msg.alert('Error', o.result.errorMsgContent);
								form.getForm().reset();
								vefiryCode.refresh();
							}
							f.disabled=false;
						},
						failure:function(fm, o){
							Ext.Msg.alert('Error', o.result.errorMsgContent);
							form.getForm().reset();
							vefiryCode.refresh();
							f.disabled=false;
						}
					});
				}
			}
		}, {
			text : 'Reset', handler:function(){
				form.getForm().reset();
				vefiryCode.refresh();
			}
		} ]
	});
});