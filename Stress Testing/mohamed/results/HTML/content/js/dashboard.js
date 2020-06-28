/*
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
var showControllersOnly = false;
var seriesFilter = "";
var filtersOnlySampleSeries = true;

/*
 * Add header in statistics table to group metrics by category
 * format
 *
 */
function summaryTableHeader(header) {
    var newRow = header.insertRow(-1);
    newRow.className = "tablesorter-no-sort";
    var cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 1;
    cell.innerHTML = "Requests";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 3;
    cell.innerHTML = "Executions";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 6;
    cell.innerHTML = "Response Times (ms)";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 1;
    cell.innerHTML = "Throughput";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 2;
    cell.innerHTML = "Network (KB/sec)";
    newRow.appendChild(cell);
}

/*
 * Populates the table identified by id parameter with the specified data and
 * format
 *
 */
function createTable(table, info, formatter, defaultSorts, seriesIndex, headerCreator) {
    var tableRef = table[0];

    // Create header and populate it with data.titles array
    var header = tableRef.createTHead();

    // Call callback is available
    if(headerCreator) {
        headerCreator(header);
    }

    var newRow = header.insertRow(-1);
    for (var index = 0; index < info.titles.length; index++) {
        var cell = document.createElement('th');
        cell.innerHTML = info.titles[index];
        newRow.appendChild(cell);
    }

    var tBody;

    // Create overall body if defined
    if(info.overall){
        tBody = document.createElement('tbody');
        tBody.className = "tablesorter-no-sort";
        tableRef.appendChild(tBody);
        var newRow = tBody.insertRow(-1);
        var data = info.overall.data;
        for(var index=0;index < data.length; index++){
            var cell = newRow.insertCell(-1);
            cell.innerHTML = formatter ? formatter(index, data[index]): data[index];
        }
    }

    // Create regular body
    tBody = document.createElement('tbody');
    tableRef.appendChild(tBody);

    var regexp;
    if(seriesFilter) {
        regexp = new RegExp(seriesFilter, 'i');
    }
    // Populate body with data.items array
    for(var index=0; index < info.items.length; index++){
        var item = info.items[index];
        if((!regexp || filtersOnlySampleSeries && !info.supportsControllersDiscrimination || regexp.test(item.data[seriesIndex]))
                &&
                (!showControllersOnly || !info.supportsControllersDiscrimination || item.isController)){
            if(item.data.length > 0) {
                var newRow = tBody.insertRow(-1);
                for(var col=0; col < item.data.length; col++){
                    var cell = newRow.insertCell(-1);
                    cell.innerHTML = formatter ? formatter(col, item.data[col]) : item.data[col];
                }
            }
        }
    }

    // Add support of columns sort
    table.tablesorter({sortList : defaultSorts});
}

$(document).ready(function() {

    // Customize table sorter default options
    $.extend( $.tablesorter.defaults, {
        theme: 'blue',
        cssInfoBlock: "tablesorter-no-sort",
        widthFixed: true,
        widgets: ['zebra']
    });

    var data = {"OkPercent": 100.0, "KoPercent": 0.0};
    var dataset = [
        {
            "label" : "KO",
            "data" : data.KoPercent,
            "color" : "#FF6347"
        },
        {
            "label" : "OK",
            "data" : data.OkPercent,
            "color" : "#9ACD32"
        }];
    $.plot($("#flot-requests-summary"), dataset, {
        series : {
            pie : {
                show : true,
                radius : 1,
                label : {
                    show : true,
                    radius : 3 / 4,
                    formatter : function(label, series) {
                        return '<div style="font-size:8pt;text-align:center;padding:2px;color:white;">'
                            + label
                            + '<br/>'
                            + Math.round10(series.percent, -2)
                            + '%</div>';
                    },
                    background : {
                        opacity : 0.5,
                        color : '#000'
                    }
                }
            }
        },
        legend : {
            show : true
        }
    });

    // Creates APDEX table
    createTable($("#apdexTable"), {"supportsControllersDiscrimination": true, "overall": {"data": [0.5923076923076923, 500, 1500, "Total"], "isController": false}, "titles": ["Apdex", "T (Toleration threshold)", "F (Frustration threshold)", "Label"], "items": [{"data": [0.0, 500, 1500, "account over view"], "isController": false}, {"data": [1.0, 500, 1500, "Go premium-1"], "isController": false}, {"data": [0.95, 500, 1500, "Go premium-0"], "isController": false}, {"data": [0.075, 500, 1500, "Home page"], "isController": false}, {"data": [0.5, 500, 1500, "Go premium"], "isController": false}, {"data": [0.2, 500, 1500, "Sign up"], "isController": false}, {"data": [0.5, 500, 1500, "web player"], "isController": false}, {"data": [0.925, 500, 1500, "account over view-0"], "isController": false}, {"data": [0.0, 500, 1500, "account over view-1"], "isController": false}, {"data": [0.65, 500, 1500, "Sign up-3"], "isController": false}, {"data": [0.95, 500, 1500, "Sign up-0"], "isController": false}, {"data": [0.95, 500, 1500, "Sign up-1"], "isController": false}, {"data": [1.0, 500, 1500, "Sign up-2"], "isController": false}]}, function(index, item){
        switch(index){
            case 0:
                item = item.toFixed(3);
                break;
            case 1:
            case 2:
                item = formatDuration(item);
                break;
        }
        return item;
    }, [[0, 0]], 3);

    // Create statistics table
    createTable($("#statisticsTable"), {"supportsControllersDiscrimination": true, "overall": {"data": ["Total", 260, 0, 0.0, 2337.065384615382, 98, 11889, 11399.8, 11633.6, 11883.51, 15.153281268213078, 283.0535500932509, 4.431469649726075], "isController": false}, "titles": ["Label", "#Samples", "KO", "Error %", "Average", "Min", "Max", "90th pct", "95th pct", "99th pct", "Transactions\/s", "Received", "Sent"], "items": [{"data": ["account over view", 20, 0, 0.0, 11696.749999999998, 11530, 11889, 11888.1, 11889.0, 11889.0, 1.667778519012675, 8.384495913942628, 0.5602693462308205], "isController": false}, {"data": ["Go premium-1", 20, 0, 0.0, 333.1, 251, 406, 381.9, 404.79999999999995, 406.0, 31.055900621118013, 128.27694342003105, 6.793478260869565], "isController": false}, {"data": ["Go premium-0", 20, 0, 0.0, 413.5999999999999, 314, 695, 505.80000000000007, 685.7499999999999, 695.0, 28.77697841726619, 69.13219424460432, 6.941321942446043], "isController": false}, {"data": ["Home page", 20, 0, 0.0, 1791.3000000000002, 1375, 2206, 2186.7, 2205.05, 2206.0, 8.798944126704795, 422.66424122855256, 1.082682578090629], "isController": false}, {"data": ["Go premium", 20, 0, 0.0, 746.7500000000001, 616, 998, 841.1, 990.1999999999998, 998.0, 20.04008016032064, 130.91906469188376, 9.217654058116233], "isController": false}, {"data": ["Sign up", 20, 0, 0.0, 1470.5, 1022, 1790, 1767.9, 1789.35, 1790.0, 10.245901639344261, 718.1436507428278, 10.085809426229508], "isController": false}, {"data": ["web player", 20, 0, 0.0, 765.05, 665, 835, 832.1, 834.9, 835.0, 22.650056625141563, 713.3363267978482, 2.6764227066817665], "isController": false}, {"data": ["account over view-0", 20, 0, 0.0, 377.3, 264, 601, 567.9000000000001, 599.65, 601.0, 22.88329519450801, 22.21288615560641, 3.195616418764302], "isController": false}, {"data": ["account over view-1", 20, 0, 0.0, 11318.199999999999, 10977, 11456, 11427.8, 11454.6, 11456.0, 1.7350568231109569, 7.038501995315347, 0.3405726771926781], "isController": false}, {"data": ["Sign up-3", 20, 0, 0.0, 540.7, 332, 661, 656.0, 660.8, 661.0, 17.873100983020553, 1180.8115504915104, 4.363550044682753], "isController": false}, {"data": ["Sign up-0", 20, 0, 0.0, 374.6, 269, 550, 501.30000000000007, 547.8, 550.0, 27.210884353741495, 31.2765731292517, 7.01530612244898], "isController": false}, {"data": ["Sign up-1", 20, 0, 0.0, 412.49999999999994, 277, 558, 544.1000000000001, 557.55, 558.0, 22.988505747126435, 32.933728448275865, 5.477729885057471], "isController": false}, {"data": ["Sign up-2", 20, 0, 0.0, 141.50000000000003, 98, 222, 188.90000000000003, 220.39999999999998, 222.0, 30.165912518853695, 43.51079374057315, 7.364724736048265], "isController": false}]}, function(index, item){
        switch(index){
            // Errors pct
            case 3:
                item = item.toFixed(2) + '%';
                break;
            // Mean
            case 4:
            // Mean
            case 7:
            // Percentile 1
            case 8:
            // Percentile 2
            case 9:
            // Percentile 3
            case 10:
            // Throughput
            case 11:
            // Kbytes/s
            case 12:
            // Sent Kbytes/s
                item = item.toFixed(2);
                break;
        }
        return item;
    }, [[0, 0]], 0, summaryTableHeader);

    // Create error table
    createTable($("#errorsTable"), {"supportsControllersDiscrimination": false, "titles": ["Type of error", "Number of errors", "% in errors", "% in all samples"], "items": []}, function(index, item){
        switch(index){
            case 2:
            case 3:
                item = item.toFixed(2) + '%';
                break;
        }
        return item;
    }, [[1, 1]]);

        // Create top5 errors by sampler
    createTable($("#top5ErrorsBySamplerTable"), {"supportsControllersDiscrimination": false, "overall": {"data": ["Total", 260, 0, null, null, null, null, null, null, null, null, null, null], "isController": false}, "titles": ["Sample", "#Samples", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors"], "items": [{"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}]}, function(index, item){
        return item;
    }, [[0, 0]], 0);

});
