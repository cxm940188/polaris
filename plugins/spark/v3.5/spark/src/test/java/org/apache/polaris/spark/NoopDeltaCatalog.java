/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.polaris.spark;

import org.apache.spark.sql.catalyst.analysis.NoSuchTableException;
import org.apache.spark.sql.connector.catalog.DelegatingCatalogExtension;
import org.apache.spark.sql.connector.catalog.Identifier;
import org.apache.spark.sql.connector.catalog.Table;
import org.apache.spark.sql.connector.catalog.TableChange;

/**
 * This is a fake delta catalog class that is used for testing. This class is a noop class that
 * directly passes all calls to the delegate CatalogPlugin configured as part of
 * DelegatingCatalogExtension.
 */
public class NoopDeltaCatalog extends DelegatingCatalogExtension {
  // This is a mock of isUnityCatalog scala val in
  // org.apache.spark.sql.delta.catalog.DeltaCatalog.
  private boolean isUnityCatalog = false;

  @Override
  public Table alterTable(Identifier ident, TableChange... changes) throws NoSuchTableException {
    return super.loadTable(ident);
  }
}
