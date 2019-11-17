import urllib.request
from bs4 import BeautifulSoup
import ssl


#inside part
ctx = ssl.create_default_context()
ctx.check_hostname = False
ctx.verify_mode = ssl.CERT_NONE


#github part
#ACTUAL PROBLEM DATA
problem_url = "http://py4e-data.dr-chuck.net/known_by_Anne.html"
problem_repetitions = 7
problem_resultPosition = 18


#Choosing the type of execution we're trying

(link, repetitions, resultPosition) = (problem_url, problem_repetitions, problem_resultPosition)


#Amount of iterations needed
for times in range(repetitions):

	#Getting the information of the correspondent url
	html = urllib.request.urlopen(link).read()
	soup = BeautifulSoup(html)
	tags = soup('a')

	#We are indicated that the first name is 1, but in Python the array begins in 0,
	#so we have to take 1 unit from the index
	link = tags[resultPosition - 1].get('href')

#Getting the content of the tag in the specified position. It should correspond to
#the answer we're looking for
result_name = tags[resultPosition - 1].contents[0]
print(result_name)