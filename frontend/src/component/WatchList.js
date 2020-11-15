import React from 'react';
import {default as store} from '../store/WatchStore'
import WatchListItem from "./WatchListItem";

class WatchList extends React.Component{

    constructor(props) {
        super(props);
        this.state = {watches : []};
        this._updateState = this._updateState.bind(this);
    }


    componentDidMount() {
        store.addChangeListener(this._updateState);
    }


    componentWillUnmount() {
        store.removeChangeListener(this._updateState);
    }

    _updateState(){
        this.setState({watches : store._watches});
    }

    render() {
        return(
            <div>
                <table className="table">
                <thead>
                    <tr>
                        <th>Óra azonosító</th>
                    </tr>
                </thead>
                <tbody>
                {this.state.watches.map(({watchId}, index)=>{
                    return(
                        <WatchListItem key={index} watchId={watchId}/>
                    );
                })}
                </tbody>
                </table>
            </div>
        );
    }
}

export default WatchList;
