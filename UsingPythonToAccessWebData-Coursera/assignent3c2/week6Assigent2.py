import json
import urllib

import urllib.request, urllib.parse, urllib.error
import json
import ssl
import urllib.request

api_key = False
# If you have a Google Places API key, enter it here
# api_key = 'AIzaSy___IDByT70'
# https://developers.google.com/maps/documentation/geocoding/intro

if api_key is False:
    api_key = 42
    serviceurl = 'http://py4e-data.dr-chuck.net/json?'
else :
    serviceurl = 'https://maps.googleapis.com/maps/api/geocode/json?'

# Ignore SSL certificate errors
ctx = ssl.create_default_context()
ctx.check_hostname = False
ctx.verify_mode = ssl.CERT_NONE


#Stroring the given parameters
serviceurl = "http://py4e-data.dr-chuck.net/json?"
# sample_address = "South Federal University"
data_address = "Columbia University"
address_wanted = data_address

#Setting the GET parameters on the URL
parameters = {"sensor": "false", "address": address_wanted}
paramsurl = urllib.parse.urlencode(parameters)

#Generating the complete URL. Printing it in order to check if it's correct.
queryurl = serviceurl + paramsurl
print("DATA URL: ", queryurl)

#Obtaining and reading the data
data = urllib.request.urlopen(queryurl).read()

#Parsing the data and looking for the field we want.
#That field is inside the "Results" array, in its first item (if our address is
#correct we can assume that the result would be the correct one) and on its
#"place_id" field
jsondata = json.loads(str(data))
place_id = jsondata["results"][0]["place_id"]
print("PLACE ID: ", place_id)
