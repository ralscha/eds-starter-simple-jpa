Ext.define('Starter.overrides.FormPanel', {
	override: 'Ext.form.Panel',

	 submit: function (options, e) {
	        options = options || {};
	 
	        var me = this,
	            formValues = me.getValues(me.getStandardSubmit() || !options.submitDisabled),
	            form = me.element.dom || {};
	 
	        //START fix for datefield    
	        for (const key of Object.keys(formValues)) {          
	           const value = formValues[key];
	           if (Ext.isDate(value)) {
	        	   formValues[key] = value.toISOString();
	           }
	        }    
            //END fix for datefield
	        
	        if (this.getEnableSubmissionForm()) {
	            form = this.createSubmissionForm(form, formValues);
	        }
	 
	        options = Ext.apply({
	            url : me.getUrl() || form.action,
	            submit: false,
	            form: form,
	            method : me.getMethod() || form.method || 'post',
	            autoAbort : false,
	            params : null,
	            waitMsg : null,
	            headers : null,
	            success : null,
	            failure : null
	        }, options || {});
	 
	        return me.fireAction('beforesubmit', [me, formValues, options, e], 'doBeforeSubmit', null, null, 'after');
	    }
});