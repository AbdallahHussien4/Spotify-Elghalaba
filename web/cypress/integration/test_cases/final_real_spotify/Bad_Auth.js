let email = 'loaywael22@outlook.com'
let password = 'MohamedSayed20'

// / <reference types="Cypress" />
describe('Bad Auth', () => {
    beforeEach(() => { // runs once before all tests in the block
        cy.visit('https://www.spotify.com/eg-en/');
        cy.get('a').contains('Log In').click();
        cy.get('#login-username').type(email);
        cy.get('#login-password').type(password);
        cy.get('#login-button').click();
        cy.wait(3000)//wait for response nse 
    });
    {
        it('access account-overview without login', () => {
            cy.get('span').contains('Profile').click()
            cy.get('a').contains('Log Out').click();
            cy.wait(1000)
            cy.visit('https://www.spotify.com/eg-en/account/overview/')
            cy.url().should('be', 'https://accounts.spotify.com/en/login?continue=https:%2F%2Fwww.spotify.com%2Feg-en%2Faccount%2Foverview%2F')
        });
    }
    {
        it('access edit-profile without login ', () => {
            cy.get('span').contains('Profile').click()
            cy.get('a').contains('Log Out').click();
            cy.wait(1000)
            cy.visit('https://www.spotify.com/eg-en/account/profile/')
            cy.url().should('be', 'https://accounts.spotify.com/en/login?continue=https:%2F%2Fwww.spotify.com%2Feg-en%2Faccount%2Foverview%2F')
        });
    }
    {
        it('access change password without login ', () => {
            cy.get('span').contains('Profile').click()
            cy.get('a').contains('Log Out').click();
            cy.wait(1000)
            cy.visit('https://www.spotify.com/eg-en/account/change-password/')
            cy.url().should('be', 'https://accounts.spotify.com/en/login?continue=https:%2F%2Fwww.spotify.com%2Feg-en%2Faccount%2Foverview%2F')
        });
    }
    {
        it('access notification setting without login ', () => {
            cy.get('span').contains('Profile').click()
            cy.get('a').contains('Log Out').click();
            cy.wait(1000)
            cy.visit('https://www.spotify.com/eg-en/account/notifications/')
            cy.url().should('be', 'https://accounts.spotify.com/en/login?continue=https:%2F%2Fwww.spotify.com%2Feg-en%2Faccount%2Foverview%2F')
        });
    }
    {
        it('access pivacy setting without login ', () => {
            cy.get('span').contains('Profile').click()
            cy.get('a').contains('Log Out').click();
            cy.wait(1000)
            cy.visit('https://www.spotify.com/eg-en/account/privacy/')
            cy.url().should('be', 'https://accounts.spotify.com/en/login?continue=https:%2F%2Fwww.spotify.com%2Feg-en%2Faccount%2Foverview%2F')
        });
    }


});