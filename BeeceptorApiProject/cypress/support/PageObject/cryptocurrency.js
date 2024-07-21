class Cryptowallet{
    registerUserandCreateWallet(method,baseurl,endpoints,data){
        cy.request({
            //method is post
            method:method,
            //baseurl with Register a user, and create his/her wallet end points
            url:baseurl + endpoints,
            //body of username password email
            body:data,
            //headers of  required
            headers:{
               "Content-Type": "application/json"
            }

        })
        .then((Response)=>{
            expect(Response.status).to.eq(200);
            const res = JSON.stringify(Response.body)
            cy.log(res)
        })
    }
    loginaUserandGenratesessionToken(method,baseurl,endpoints,data){
        cy.request({
            method:method,
            url:baseurl + endpoints,
            body:data,

            headers:{
               "Content-Type": "application/json"
            }

        })
        .then((Response)=>{
            expect(Response.status).to.eq(200);
            const res = JSON.stringify(Response.body)
            cy.log(res)
        })
    }
    retriveWalletBalance(method,baseurl,endpoints){
        cy.request({
            method: method,
            url:baseurl + endpoints,
            headers:{
                "Content-Type":"application/json"}  
        }).then((Response)=>{
            expect(Response.status).to.eq(200);
            const res = JSON.stringify(Response.body)
            cy.log(res)
        })

    }
    listTranscationsdoneByuser(method,baseurl,endpoints){
        cy.request({
            method: method,
            url:baseurl + endpoints,
            headers:{
                "Content-Type":"application/json"}  
        })
        .then((Response)=>{
            expect(Response.status).to.eq(200);
            const res = JSON.stringify(Response.body)
            cy.log(res)
        })
    }
    transfer5ETHtoRecipient(method,baseurl,endpoints,data){
        cy.request({
            method:method,
            url:baseurl + endpoints,
            body:data,
            headers:{
                "Content-Type":"application/json"}  
        })
        .then((Response)=>{
            expect(Response.status).to.eq(200);
            const res = JSON.stringify(Response.body)
            cy.log(res)
        })
    }
    calculateTransationFeesandReturnEstimatedCost(method,baseurl,endpoints,data){
        cy.request({
            method: method,
            url:baseurl + endpoints,
            body:data,

            headers:{
               "Content-Type": "application/json"
            }

        }).then((Response)=>{
            expect(Response.status).to.eq(200);
            const res = JSON.stringify(Response.body)
            cy.log(res)
        })
    }
    getObjectwithAllAvailableCurrencyExchangeRates(method,baseurl,endpoints){
        cy.request({
            method: method,
            url:baseurl + endpoints,
            headers:{
                "Content-Type":"application/json"}  
        })
        .then((Response)=>{
            expect(Response.status).to.eq(200);
            const res = JSON.stringify(Response.body)
            cy.log(res)
        })
    }

}
export default Cryptowallet;