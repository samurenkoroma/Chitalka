import requests
from json import JSONDecodeError


def get_json(url, params):
    r = requests.get(url, params=params)
    try:
        data = r.json()
        print(data)
    except JSONDecodeError:
        print("Response is not JSON format")


def get_csv(url, params):
    payload.update({"datatype": "csv"})
    r = requests.get(url, params=params)
    try:
        data = r.json()
        print(data)
    except JSONDecodeError:
        print("Response is not JSON format")


if __name__ == '__main__':
    url = f'https://www.alphavantage.co/query'

    payload = {
        "function": "CRYPTO_INTRADAY",
        "symbol": "ETH",
        "interval": "5min",
        "outputsize": "full",
        "apikey": "06CCJTZEPU7YZ3W9",

    }

    get_json(url, payload)
