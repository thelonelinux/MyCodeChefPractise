
from urllib.request import urlopen

from bs4 import BeautifulSoup
import urllib
from urllib.request import urlopen

import ssl

# Ignore SSL certificate errors
ctx = ssl.create_default_context()
ctx.check_hostname = False
ctx.verify_mode = ssl.CERT_NONE

data_url = "http://py4e-data.dr-chuck.net/comments_203535.html"

# Getting the html information and parsing it with BeautifulSoup
html = urllib.request.urlopen(data_url).read()
soup = BeautifulSoup(html)

# Getting a list with the "span" tags
tags = soup('span')

# Counting the sum of all the values within the span tags
count = 0
for tag in tags:
    # We need to cast them to int, as they're parsed as text strings
    count += int(tag.contents[0])

print(count)
