// / <reference types="Cypress" />
describe('login', () => {
    beforeEach(() => { // runs once before all tests in the block
        cy.visit('https://spotify-elghalaba.me/');
        cy.get('.v-btn__content').eq(2).click();
        cy.get('#emailField').type('mohamed.sayed8899@hotmail.com');
        cy.get('#passwordField').type('20119820');
        cy.get('.v-btn__content').contains('Log In').click();
        cy.wait(3000)//wait for response 
        cy.get("#inner-user-btn").click();
        cy.wait(500)//wait for response 
    });
    {
        it('access home page without login', () => {
            cy.get('#logout-item').click()
            cy.wait(1000)
            cy.visit('https://spotify-elghalaba.me/home')
            //cy.url().should('contain', "login")
            cy.wait(1000)
            cy.url().should('be', 'https://spotify-elghalaba.me/')
            // 404 not found
        });
    }

    {
        it('access account overview without login', () => {
            cy.get('#logout-item').click()
            cy.wait(1000)
            cy.visit('https://spotify-elghalaba.me/account/overview')
            //cy.url().should('contain', "login")
            cy.wait(1000)
            cy.url().should('be', 'https://spotify-elghalaba.me/')
        });
    }

    {
        it('access edit-profile without login', () => {
            cy.get('#logout-item').click()
            cy.wait(1000)
            cy.visit('https://spotify-elghalaba.me/account/overview')
            //cy.url().should('contain', "login")
            cy.wait(1000)
            cy.url().should('be', 'https://spotify-elghalaba.me/')
        });
    }

    {
        it('access change-password without login', () => {
            cy.get('#logout-item').click()
            cy.wait(1000)
            cy.visit('https://spotify-elghalaba.me/account/change-password')
            //cy.url().should('contain', "login")
            cy.wait(1000)
            cy.url().should('be', 'https://spotify-elghalaba.me/')
        });
    }

    {
        it('access notification setting without login', () => {
            cy.get('#logout-item').click()
            cy.wait(1000)
            cy.visit('https://spotify-elghalaba.me/account/notifications')
            cy.url().should('contain', "login")
        });
    }

});