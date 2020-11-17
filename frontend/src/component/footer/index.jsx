import React from 'react';
import './footer.css';

function Footer() {
    return (
        <footer className="card-footer fixed-bottom position-static">
            <p className="text-center">&copy;{new Date().getFullYear()} AFP1 Négyes csapat - All rights reserved.</p>
        </footer>
    )
}
export default Footer;