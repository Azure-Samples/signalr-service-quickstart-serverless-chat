// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See LICENSE file in the project root for full license information.

module.exports = async function (context, req, connectionInfo) {
  context.res.json(connectionInfo);
};