///<reference types="cypress"/>
import Cryptowallet from "../../support/PageObject/cryptocurrency";
describe('cypto currency wallet api testing', () => {
    let cw=new Cryptowallet();
    let baseurl="https://crypto-wallet-server.mock.beeceptor.com";
    it('Register a user, and create his/her wallet', () => {
        cw.registerUserandCreateWallet('POST', baseurl, '/api/v1/register',{
            "username": "user123",
            "password": "securepassword",
            "email": "user@example.com"
        })
    });
    it('Login the user and generate a session token', () => {
        cw.loginaUserandGenratesessionToken('POST', baseurl, '/api/v1/login',{
            "username": "user123",
            "password": "securepassword"
        })
    });
    it('Retrieve the wallet balance', () => {
       cw.retriveWalletBalance('GET', baseurl, '/api/v1/balance') 
    });
    it('List all the transactions done by the user', () => {
        cw.listTranscationsdoneByuser('GET', baseurl, '/api/v1/transactions')
    });
    it('Transfer 5 ETH to a recipient', () => {
        cw.transfer5ETHtoRecipient('POST', baseurl, '/api/v1/transactions',{
            "recipient_address": "0x1234567890ABCDEF",
            "amount": 5.0,
            "currency": "ETH"
        })
    });
    it('Calculate transaction fees and return estimated cost', () => {
       cw.calculateTransationFeesandReturnEstimatedCost('POST', baseurl, '/api/v1/transaction_fee',{
        "amount": 2.5,
        "currency": "BTC",
        "recipient_address": "0x1234567890ABCDEF"
        
       }) 
    });
    it('Get an object with all available currency exchange rates', () => {
        cw.getObjectwithAllAvailableCurrencyExchangeRates('GET', baseurl, '/api/v1/exchange_rates') 
    });
});