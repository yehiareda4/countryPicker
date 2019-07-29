# countryPicker


Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.yehiareda4:countryPicker:1.0.0'
	}

Useing

        //Create Instance
        CountryPicker picker = CountryPicker.newInstance("CountryPicker", this);

        //Show Picker
        picker.show(getSupportFragmentManager(),"");

        //dismiss Picker
        picker.dismiss();

        //Listener
        picker.setListener(new CountryPickerListener() {
            @Override
            public void onSelectCountry(Country country) {
               
            }
        });
        