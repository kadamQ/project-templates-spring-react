import React from "react";
import {Nav} from "react-bootstrap";
import './navbar.css';

class Navbar extends React.Component
{
    render()
    {
        return(
            <Nav className="navbar navbar-light bg-light" class="fixed-top">
                <span className="navbar-brand mb-0 h1">AquaPark<p></p></span>
            </Nav>
        )

    }
}
export default Navbar;