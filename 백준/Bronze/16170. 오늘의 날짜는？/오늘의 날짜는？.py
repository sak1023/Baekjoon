import datetime
now = datetime.datetime.now() + datetime.timedelta(hours=9)

for _ in str(now.date()).split("-"):
    print(_)