/* ----------------------------
	CustomValidation prototype
	- Keeps track of the list of invalidity messages for this input
	- Keeps track of what validity checks need to be performed for this input
	- Performs the validity checks and sends feedback to the front end
---------------------------- */

function CustomValidation(input) {
	this.invalidities = [];
	this.validityChecks = [];

	//add reference to the input node
	this.inputNode = input;

	//trigger method to attach the listener
	this.registerListener();
}

CustomValidation.prototype = {
	addInvalidity: function (message) {
		this.invalidities.push(message);
	},
	getInvalidities: function () {
		return this.invalidities.join('. \n');
	},
	checkValidity: function (input) {
		for (var i = 0; i < this.validityChecks.length; i++ ) {

			var isInvalid = this.validityChecks[i].isInvalid(input);
			if (isInvalid) {
				this.addInvalidity(this.validityChecks[i].invalidityMessage);
			}

			var requirementElement = this.validityChecks[i].element;

			if (requirementElement) {
				if (isInvalid) {
					requirementElement.classList.add('invalid');
					requirementElement.classList.remove('valid');
				} else {
					requirementElement.classList.remove('invalid');
					requirementElement.classList.add('valid');
				}

			} // end if requirementElement
		} // end for
	},
	checkInput: function() { // checkInput now encapsulated

		this.inputNode.CustomValidation.invalidities = [];
		this.checkValidity(this.inputNode);

		if ( this.inputNode.CustomValidation.invalidities.length === 0 && this.inputNode.value !== '' ) {
			this.inputNode.setCustomValidity('');
		} else {
			var message = this.inputNode.CustomValidation.getInvalidities();
			this.inputNode.setCustomValidity(message);
		}
	},
	registerListener: function() { //register the listener here

		var CustomValidation = this;

		this.inputNode.addEventListener('input', function() {
			CustomValidation.checkInput();
		});


	}

};



/* ----------------------------
	Validity Checks
	The arrays of validity checks for each input
	Comprised of three things
		1. isInvalid() - the function to determine if the input fulfills a particular requirement
		2. invalidityMessage - the error message to display if the field is invalid
		3. element - The element that states the requirement
---------------------------- */

var oldPasswordValidityChecks = [
	{
		isInvalid: function(input) {
			return input.value.length < 8 | input.value.length > 20;
		},
		invalidityMessage: 'This input needs to be between 8 and 100 characters',
		element: document.querySelector('label[for="old_password"] .input-requirements li:nth-child(1)')
	},
	{
		isInvalid: function(input) {
			return !input.value.match(/[0-9]/g) | input.value.length == 0;
		},
		invalidityMessage: 'At least 1 number is required',
		element: document.querySelector('label[for="old_password"] .input-requirements li:nth-child(2)')
	},
	{
		isInvalid: function(input) {
			return !input.value.match(/[a-z]/g) | input.value.length == 0;
		},
		invalidityMessage: 'At least 1 lowercase letter is required',
		element: document.querySelector('label[for="old_password"] .input-requirements li:nth-child(3)')
	},
	{
		isInvalid: function(input) {
			return !input.value.match(/[A-Z]/g) | input.value.length == 0;
		},
		invalidityMessage: 'At least 1 uppercase letter is required',
		element: document.querySelector('label[for="old_password"] .input-requirements li:nth-child(4)')
	},
	{
		isInvalid: function(input) {
			return !input.value.match(/[\!\@\#\$\%\^\&\*]/g) | input.value.length == 0;
		},
		invalidityMessage: 'You need one of the required special characters',
		element: document.querySelector('label[for="old_password"] .input-requirements li:nth-child(5)')
	}
];

var newPasswordValidityChecks = [
	{
		isInvalid: function(input) {
			return input.value.length < 8 | input.value.length > 20;
		},
		invalidityMessage: 'This input needs to be between 8 and 100 characters',
		element: document.querySelector('label[for="new_password"] .input-requirements li:nth-child(1)')
	},
	{
		isInvalid: function(input) {
			return !input.value.match(/[0-9]/g) | input.value.length == 0;
		},
		invalidityMessage: 'At least 1 number is required',
		element: document.querySelector('label[for="new_password"] .input-requirements li:nth-child(2)')
	},
	{
		isInvalid: function(input) {
			return !input.value.match(/[a-z]/g) | input.value.length == 0;
		},
		invalidityMessage: 'At least 1 lowercase letter is required',
		element: document.querySelector('label[for="new_password"] .input-requirements li:nth-child(3)')
	},
	{
		isInvalid: function(input) {
			return !input.value.match(/[A-Z]/g) | input.value.length == 0;
		},
		invalidityMessage: 'At least 1 uppercase letter is required',
		element: document.querySelector('label[for="new_password"] .input-requirements li:nth-child(4)')
	},
	{
		isInvalid: function(input) {
			return !input.value.match(/[\!\@\#\$\%\^\&\*]/g) | input.value.length == 0;
		},
		invalidityMessage: 'You need one of the required special characters',
		element: document.querySelector('label[for="new_password"] .input-requirements li:nth-child(5)')
	},
	{
		isInvalid: function(input) {
			return passwordRepeatInput.value.length == 0 & input.value != passwordRepeatInput.value;
		},
		invalidityMessage: 'Repeat this password'
	}
];

var passwordRepeatValidityChecks = [
	{
		isInvalid: function(input) {
			return input.value != oldPasswordInput.value | input.value.length == 0;
		},
		invalidityMessage: 'This password needs to match the first one'
	}
];

/* ----------------------------
	Setup CustomValidation
	Setup the CustomValidation prototype for each input
	Also sets which array of validity checks to use for that input
---------------------------- */

var oldPasswordInput = document.getElementById('old_password');
var newPasswordInput = document.getElementById('new_password');
var passwordRepeatInput = document.getElementById('password_repeat');

oldPasswordInput.CustomValidation = new CustomValidation(oldPasswordInput);
oldPasswordInput.CustomValidation.validityChecks = oldPasswordValidityChecks;

newPasswordInput.CustomValidation = new CustomValidation(newPasswordInput);
newPasswordInput.CustomValidation.validityChecks = newPasswordValidityChecks;

passwordRepeatInput.CustomValidation = new CustomValidation(passwordRepeatInput);
passwordRepeatInput.CustomValidation.validityChecks = passwordRepeatValidityChecks;

/* ----------------------------
	Event Listeners
---------------------------- */

var inputs = document.querySelectorAll('input:not([type="submit"])');


var submit = document.querySelector('input[type="submit"])');
var form = document.getElementById('reg-form');

function validate() {
	for (var i = 0; i < inputs.length; i++) {
		inputs[i].CustomValidation.checkInput();
	}
}

submit.addEventListener('click', validate);
form.addEventListener('submit', validate);