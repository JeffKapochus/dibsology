import React from "react";
import "./NavBar.css";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faBars } from '@fortawesome/free-solid-svg-icons'

export class NavBar extends React.Component {

    toggleExpansion(){
        document.getElementById("navBar").classList.toggle("unexpanded");
        document.getElementById("navBar").classList.toggle("expanded");
    }
    
    render() {
        return (
            <div id="navBar" className="unexpanded">
                <ul>
                    <li onClick={this.toggleExpansion}><FontAwesomeIcon icon={faBars}/></li>
                    <li>
                        <a href="/">Home</a>
                    </li>
                    <li>
                        <a href="/submissions">Submissions</a>
                    </li>
                    <li>
                        <a href="/user">Account</a>
                    </li>
                </ul>
            </div>
        );
    }
}
