import os

from pyokx.pyokx import OKXClient, Marketdata, Account

# create the base client:
client = OKXClient(
    key="d7eae721-a6c5-4920-8538-d3984519a814",
    secret="DB126519457BAE81A7363A113FBDB592",
    passphrase="BOoD2rk@y2YuQMlgIfS0",
    test=True  # if using the test OKX environment
)

if __name__ == '__main__':
    # create a component for the Account API by passing the client dependency
    account = Marketdata(client)

    # get positions
    api_response = account.get_candlesticks_history("TON-USDT", bar="1H")

    # you can convert to a pandas dataframe to make it more readable
    # df_response = api_response.to_df()
    print(api_response.to_df())

    # # or you can get the raw response
    # raw_response = api_response.response
    # print(raw_response)
