// / <reference types="Cypress" />
let password = 'MohamedSayed201'
let email = 'loaywael22@outlook.com'
let newemail = 'loaywael33@outlook.com'
let phone = '01099122255'
let gender = 'Male'
let day = '2'
let month = '2'
let year = '1998'
let country = 'Egypt'

describe('Edit Profile', () => {
    beforeEach(() => { // runs once before all tests in the block
        cy.visit('https://www.spotify.com/eg-en/');
        cy.get('a').contains('Log In').click();
        cy.get('#login-username').type(email);
        cy.get('#login-password').type(password);
        cy.get('#login-button').click();
        cy.wait(3000)//wait for response 
        cy.get("a").contains('Edit profile').click();
        cy.wait(500)//wait for response 
    });

    {
        it('change date', () => {
            cy.get('#profile_birthdate_month').select(month);
            cy.get('#profile_birthdate_day').select(day);
            cy.get('#profile_birthdate_year').select(year);
            cy.get('#profile_save_profile').click();//edit profile
            cy.wait(1000);
            cy.get('p').contains('Profile saved');
        });

    }

    {
        it('change gender', () => {
            cy.get('#profile_gender').select(gender);
            cy.get('#profile_save_profile').click();//edit profile
            cy.wait(1000);
            cy.get('p').contains('Profile saved');
        });

    }
    {
        it('change country', () => {
            cy.get('#profile_country').select(country);
            cy.get('#profile_save_profile').click();//edit profile
            cy.wait(1000);
            cy.get('p').contains('Profile saved');
        });

    }
    {

        it('change mobile', () => {
            cy.get('#profile_mobile_number').clear();
            cy.get('#profile_mobile_number').type(phone);
            cy.get('#profile_save_profile').click();//edit profile
            cy.wait(1000);
            cy.get('p').contains('Profile saved');
        });
    }

    {

        it('change email', () => {
            cy.get('#profile_email').clear();
            cy.get('#profile_email').type(newemail);
            cy.wait(100);
            cy.get('#profile_confirmPassword').type(password);
            cy.get('#profile_save_profile').click();//edit profile
            cy.wait(1000);
            cy.get('p').contains('Profile saved');
        });
    }
});


