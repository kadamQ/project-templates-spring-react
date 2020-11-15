import React from "react";
import {Nav} from "react-bootstrap";

class Navbar extends React.Component
{
    render()
    {
        return(

            <div>
                <Nav className="navbar navbar-light bg-light">
                    <span className="navbar-brand mb-0 h1">AquaPark</span>
                </Nav>
            </div>
        )

    }
}
export default Navbar;