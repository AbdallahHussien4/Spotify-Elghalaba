// / <reference types="Cypress" />
describe('login', () => {
    beforeEach(() => { // runs once before all tests in the block
        cy.visit('https://spotify-elghalaba.me/');
        cy.get('.v-btn__content').eq(2).click();
        cy.get('#emailField').type('mohamed.sayed8899@hotmail.com');
        cy.get('#passwordField').type('12345678');
        cy.get('.v-btn__content').contains('Log In').click();
        cy.wait(3000)//wait for response 
        cy.get("#inner-user-btn").click();
        cy.wait(500)//wait for response 
    });

    {
        it('get user info', () => {
            cy.get('.v-list-item__title').contains("Account").click();
            cy.wait(500);//wait for response 
            cy.get(".body-1").eq(1).should('contain', 'mohamed.sayed8899@hotmail.com')//email
        });

    }


});