Ext.define('Starter.view.form.FormPanel', {
	extend: 'Ext.form.Panel',

	controller: {
		xclass: 'Starter.view.form.FormController'
	},

	bodyPadding: 10,
	title: 'FORM_LOAD, FORM_POST and SIMPLE',

	layout: {
		type: 'vbox',
		align: 'stretch'
	},

	api: {
		load: 'formLoadService.getFormData',
		submit: 'formSubmitService.handleFormSubmit'
	},
	paramsAsHash: true,

	defaults: {
		labelWidth: 137
	},

	items: [ {
		xtype: 'textfield',
		name: 'osName',
		label: 'OS Name',
		required: true
	}, {
		xtype: 'textfield',
		name: 'osVersion',
		label: 'OS Version',
		required: true
	}, {
		xtype: 'numberfield',
		name: 'availableProcessors',
		label: 'Available Processors',
		required: true
	}, {
		xtype: 'datefield',
		name: 'date',
		label: 'Date',
		dateFormat: 'Y-m-d',
		required: true
	}, {
		xtype: 'filefield',
		name: 'screenshot',
		label: 'Screenshot',
		accept: 'image'
	}, {
		xtype: 'textareafield',
		name: 'remarks',
		label: 'Remarks',
		flex: 1
	} ],

	buttons: [ {
		xtype: 'button',
		text: 'Call FORM_LOAD method',
		handler: 'load'
	}, {
		xtype: 'button',
		handler: 'fillRemark',
		text: 'Call SIMPLE method'
	}, {
		text: 'Submit',
		handler: 'submit'
	} ]

});