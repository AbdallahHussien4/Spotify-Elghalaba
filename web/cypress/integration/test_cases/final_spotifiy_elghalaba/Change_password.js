// / <reference types="Cypress" />
let password = '20119820'
let newpassword = '2011982011'
describe(' Change Password', () => {
    beforeEach(() => { // runs once before all tests in the block
        cy.visit('https://spotify-elghalaba.me/');
        cy.get('.v-btn__content').eq(2).click();
        cy.get('#emailField').type('mohamed.sayed8899@hotmail.com');
        cy.get('#passwordField').type(password);
        cy.get('.v-btn__content').contains('Log In').click();
        cy.wait(3000)//wait for response 
        cy.get("#inner-user-btn").click();
        cy.wait(500)//wait for response 
    });

    {
        it('wrong password', () => {
            cy.get('.v-list-item__title').contains("Account").click();
            cy.wait(500);//wait for response 
            cy.get('a').eq(6).click();//edit profile
            cy.get('#currentPwField').type('1234567890')
            cy.get('#newPwField').type(newpassword)
            cy.get('#retypeNewPwField').type(newpassword)
            cy.get('#saveBtn').click();
            cy.wait(2000);
            cy.get('#errorBar').contains("Incorrect password ")
        });

    }

    {
        it(' Correct password ', () => {
            cy.get('.v-list-item__title').contains("Account").click();
            cy.wait(500);//wait for response 
            cy.get('a').eq(6).click();//edit profile
            cy.get('#currentPwField').type(password)
            cy.get('#newPwField').type(newpassword)
            cy.get('#retypeNewPwField').type(newpassword)
            cy.get('#saveBtn').click();
            password = newpassword;
        });

    }

    {
        it('login with new password ', () => {
            //all foreach commands will be applied
            cy.get('.v-list-item__title').contains("Account").click();

        });

    }





});

