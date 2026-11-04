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
    cell.colSpan = 7;
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
            "label" : "FAIL",
            "data" : data.KoPercent,
            "color" : "#FF6347"
        },
        {
            "label" : "PASS",
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
    createTable($("#apdexTable"), {"supportsControllersDiscrimination": true, "overall": {"data": [0.686060606060606, 500, 1500, "Total"], "isController": false}, "titles": ["Apdex", "T (Toleration threshold)", "F (Frustration threshold)", "Label"], "items": [{"data": [0.49333333333333335, 500, 1500, "https://blazedemo.com/"], "isController": false}, {"data": [0.8816666666666667, 500, 1500, "https://blazedemo.com/purchase.php"], "isController": false}, {"data": [0.9173333333333333, 500, 1500, "Flight_Select"], "isController": true}, {"data": [0.49333333333333335, 500, 1500, "Test"], "isController": true}, {"data": [0.498, 500, 1500, "https://blazedemo.com/confirmation.php"], "isController": false}, {"data": [0.9533333333333334, 500, 1500, "https://blazedemo.com/reserve.php"], "isController": false}, {"data": [0.9533333333333334, 500, 1500, "Flight_Seacrh"], "isController": true}, {"data": [0.4786666666666667, 500, 1500, "Purchase_info"], "isController": true}, {"data": [0.498, 500, 1500, "Purchase_Flight"], "isController": true}]}, function(index, item){
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
    createTable($("#statisticsTable"), {"supportsControllersDiscrimination": true, "overall": {"data": ["Total", 4500, 0, 0.0, 548.9906666666666, 371, 6701, 534.0, 671.0, 777.0, 1280.909999999998, 21.11427043157569, 127.42887423402118, 18.007613454013118], "isController": false}, "titles": ["Label", "#Samples", "FAIL", "Error %", "Average", "Min", "Max", "Median", "90th pct", "95th pct", "99th pct", "Transactions/s", "Received", "Sent"], "items": [{"data": ["https://blazedemo.com/", 750, 0, 0.0, 616.0346666666667, 493, 6701, 551.5, 631.8, 828.6499999999988, 2789.510000000004, 9.960953063989162, 46.27477475794884, 7.392894852179457], "isController": false}, {"data": ["https://blazedemo.com/purchase.php", 1500, 0, 0.0, 480.59733333333304, 371, 3276, 439.0, 585.0, 653.0, 1011.8600000000001, 13.197371083680132, 86.54365112969496, 10.213785726383303], "isController": false}, {"data": ["Flight_Select", 750, 0, 0.0, 465.7066666666664, 371, 3276, 431.0, 541.9, 616.8999999999999, 1004.8600000000001, 9.889631710115115, 64.85277943978532, 8.86590030262273], "isController": true}, {"data": ["Test", 750, 0, 0.0, 616.036, 493, 6701, 551.5, 631.8, 828.6499999999988, 2789.510000000004, 9.94523490644849, 46.201754215122065, 7.381229032129739], "isController": true}, {"data": ["https://blazedemo.com/confirmation.php", 1500, 0, 0.0, 634.6486666666669, 465, 3528, 588.0, 766.9000000000001, 883.0, 1331.88, 10.35539723303786, 58.45155205830779, 10.244157614323585], "isController": false}, {"data": ["https://blazedemo.com/reserve.php", 750, 0, 0.0, 447.4173333333337, 374, 4000, 422.0, 495.79999999999995, 561.3499999999998, 947.6600000000003, 10.07698818976984, 72.16338555732462, 8.551662829013663], "isController": false}, {"data": ["Flight_Seacrh", 750, 0, 0.0, 447.4186666666665, 374, 4000, 422.0, 495.79999999999995, 561.3499999999998, 947.6600000000003, 10.07752979589643, 72.1672641102213, 8.552122453744138], "isController": true}, {"data": ["Purchase_info", 750, 0, 0.0, 1117.8386666666677, 906, 4153, 1056.0, 1312.8, 1452.35, 2225.3200000000006, 9.760414362124386, 119.0984315420804, 16.013179812860322], "isController": true}, {"data": ["Purchase_Flight", 750, 0, 0.0, 646.946666666666, 495, 3242, 600.0, 801.0, 925.8999999999999, 1181.6600000000003, 9.821381802943796, 55.43719881095804, 9.715878678107485], "isController": true}]}, function(index, item){
        switch(index){
            // Errors pct
            case 3:
                item = item.toFixed(2) + '%';
                break;
            // Mean
            case 4:
            // Mean
            case 7:
            // Median
            case 8:
            // Percentile 1
            case 9:
            // Percentile 2
            case 10:
            // Percentile 3
            case 11:
            // Throughput
            case 12:
            // Kbytes/s
            case 13:
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
    createTable($("#top5ErrorsBySamplerTable"), {"supportsControllersDiscrimination": false, "overall": {"data": ["Total", 4500, 0, "", "", "", "", "", "", "", "", "", ""], "isController": false}, "titles": ["Sample", "#Samples", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors"], "items": [{"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}]}, function(index, item){
        return item;
    }, [[0, 0]], 0);

});
